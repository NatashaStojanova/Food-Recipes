package com.projectrecipes.natashastojanova.foodrecipes.web.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.projectrecipes.natashastojanova.foodrecipes.dto.IngDTO;
import com.projectrecipes.natashastojanova.foodrecipes.dto.RecipeDTO;
import com.projectrecipes.natashastojanova.foodrecipes.exceptions.CategoryNotFoundException;
import com.projectrecipes.natashastojanova.foodrecipes.exceptions.RecipeAlreadyExistsException;
import com.projectrecipes.natashastojanova.foodrecipes.exceptions.RecipeNotFoundException;
import com.projectrecipes.natashastojanova.foodrecipes.model.*;
import com.projectrecipes.natashastojanova.foodrecipes.service.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
/**
 * @author Natasha Stojanova
 */
@RestController
@RequestMapping("/recipes")
@CrossOrigin("*")
public class RecipeController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final CategoryService categoryService;
    private final RecipeIngredientService recipeIngredientService;
    private final UserService userService;

    private String imagesFolder = "C:\\Users\\natas\\Desktop\\FCSE\\FoodRecipes\\backend\\src\\main\\resources\\images\\";

    public RecipeController(RecipeService recipeService,
                            IngredientService ingredientService,
                            CategoryService categoryService,
                            RecipeIngredientService recipeIngredientService,
                            UserService userService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.categoryService = categoryService;
        this.recipeIngredientService = recipeIngredientService;
        this.userService = userService;
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.findAll();
    }


    //create new Recipe
    @RequestMapping(method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public Recipe addNewRecipe(@ModelAttribute RecipeDTO recipeDTO) {
        if (recipeService.existsByName(recipeDTO.getName()))
            throw new RecipeAlreadyExistsException();

        Recipe newRecipe = new Recipe();
        Gson gson = new Gson();
        List<Map<String, String>> ingrs = gson.fromJson(recipeDTO.getIngredientsList(), List.class);
        newRecipe.setName(recipeDTO.getName());
        newRecipe.setDescription(recipeDTO.getDescription());
        newRecipe.setTime(recipeDTO.getTime());
        Optional<Category> category = categoryService.findById(recipeDTO.getCategory());
        newRecipe.setCategory(category.get());

        Optional<User> user = userService.findByUsername(recipeDTO.getUsername());
        if (user.isPresent())
            newRecipe.setUser(user.get());

        //saving image into directory
        InputStream inputStream = null;
        OutputStream outputStream = null;
        MultipartFile file = recipeDTO.getImage();
        String fileName = file.getOriginalFilename();
        File newFile = new File(imagesFolder + fileName);
        try {
            inputStream = file.getInputStream();

            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            outputStream = new FileOutputStream(newFile);
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        newRecipe.setImage(imagesFolder + fileName);

        recipeService.save(newRecipe);

        ingrs.forEach((ingredient) -> {
            Optional<Ingredient> ing = ingredientService.findOne(Long.parseLong(ingredient.get("id")));
            float amount = Float.parseFloat(ingredient.get("amount"));
            if (ing.isPresent()) {
                RecipeIngredient recipeIngredient = new RecipeIngredient();
                recipeIngredient.setIngredient(ing.get());
                recipeIngredient.setAmount(amount);
                recipeIngredient.setRecipe(newRecipe);
                recipeIngredientService.save(recipeIngredient);
            }
        });

        return newRecipe;
    }

    //give me the recipe with specific ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RecipeDTO getRecipe(@PathVariable("id") Long id) {
        Recipe recipe;
        RecipeDTO recipeDTO = new RecipeDTO();
        if (recipeService.findOne(id).isPresent()) {
            recipe = recipeService.findOne(id).get();
            List<Ingredient> list = new ArrayList<>();
            recipe.getIngredientList().stream().forEach(item -> {
                list.add(item.getIngredient());
            });
            recipeDTO.setIngredients(list);
            recipeDTO.setName(recipe.getName());
            recipeDTO.setTime(recipe.getTime());
            recipeDTO.setRecipeCategory(recipe.getCategory());
            recipeDTO.setUser(recipe.getUser());
            recipeDTO.setDescription(recipe.getDescription());
        } else
            throw new RecipeNotFoundException();

        return recipeDTO;
    }

    @RequestMapping(value = "/search/{term}", method = RequestMethod.GET)
    public List<Recipe> searchRecipeByName(@PathVariable("term") String term) {
        if (term.isEmpty()) {
            return recipeService.findAll();
        }
        return recipeService.searchByName(term);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public List<Recipe> searchRecipeByCategory(@PathVariable("id") Long id) {
        Optional<Category> category = categoryService.findById(id);
        List<Recipe> recipes = new ArrayList<>();
        if (!category.isPresent())
            throw new CategoryNotFoundException();

        recipeService.findAll().stream().forEach(recipe -> {
            if (recipe.getCategory().getName().equals(category.get().getName()))
                recipes.add(recipe);
        });
        return recipes;
    }

    //show all recipes with specific ingredients
    @RequestMapping(value = "/checkIngredients", method = RequestMethod.POST, consumes = "application/json")
    public List<Recipe> searchRecipeByIngredients(@RequestBody List<Long> ingredients) {

        List<Recipe> recipeList = new ArrayList<>();
        recipeService.findAll().forEach(recipe -> {
            List<Long> ing_ID = new ArrayList<>();
            recipeService.findOne(recipe.getId()).get().getIngredientList().forEach(ingredient -> {
                ing_ID.add(ingredient.getIngredient().getId());
            });
            if (ing_ID.containsAll(ingredients)) {
                recipeList.add(recipe);
            }
        });
        return recipeList;
    }

    private User getSignedInUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String email = authentication.getPrincipal().toString();
        return userService.findByEmail(email);
    }
}

