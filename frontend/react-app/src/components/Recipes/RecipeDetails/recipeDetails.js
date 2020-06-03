import React, {useEffect, useState} from 'react';
import {useParams, withRouter} from "react-router-dom";
import {makeStyles} from '@material-ui/core/styles';
import clsx from 'clsx';
import Card from '@material-ui/core/Card';
import CardHeader from '@material-ui/core/CardHeader';
import CardMedia from '@material-ui/core/CardMedia';
import CardContent from '@material-ui/core/CardContent';
import CardActions from '@material-ui/core/CardActions';
import Collapse from '@material-ui/core/Collapse';
import Avatar from '@material-ui/core/Avatar';
import IconButton from '@material-ui/core/IconButton';
import Typography from '@material-ui/core/Typography';
import {red} from '@material-ui/core/colors';
import FavoriteIcon from '@material-ui/icons/Favorite';
import ShareIcon from '@material-ui/icons/Share';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import MoreVertIcon from '@material-ui/icons/MoreVert';
import axios from "../../../axios/axios";

const useStyles = makeStyles((theme) => ({
    root: {
        display: 'block',
        width: '20vw',
    },
    media: {
        height: 0,
        paddingTop: '56.25%', // 16:9
    },
    expand: {
        transform: 'rotate(0deg)',
        marginLeft: 'auto',
        transition: theme.transitions.create('transform', {
            duration: theme.transitions.duration.shortest,
        }),
    },
    expandOpen: {
        transform: 'rotate(180deg)',
    },
    avatar: {
        backgroundColor: red[500],
    },
}));

const RecipeDetails = (props) => {
    const classes = useStyles();
    const [expanded, setExpanded] = React.useState(false);
    const {id} = useParams();

    const [recipe, setRecipe] = useState({});


    useEffect(() => {
        axios.get("/recipes/" + props.recipe.id).then((data) => {
            console.log(data.data);
            setRecipe(data.data);
        });
    }, []);


    const handleExpandClick = () => {

        setExpanded(!expanded);

    };

    return (
        <div>
            {recipe !== undefined && recipe.ingredients !== undefined && recipe.recipeCategory !== undefined ?
                <div className="container">
                    <Card className={classes.root}>
                        <CardHeader
                            avatar={
                                <Avatar aria-label="recipe" className={classes.avatar}>
                                    {recipe.user.username.charAt(0).toUpperCase()}
                                </Avatar>
                            }
                            action={
                                <IconButton aria-label="settings">
                                    <MoreVertIcon/>
                                </IconButton>
                            }
                            title={recipe.user.username}
                            subheader={props.recipe.time}
                        />
                        <CardMedia
                            className={classes.media}
                            image="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQfrWgL1flECdzIoCKOqvQDjtbDqWFNzs5Z1dAvp8oKfL93AaLe&usqp=CAU"
                            title="Paella dish"
                        />
                        <CardContent>
                            <h2>{recipe.name}</h2>
                            <Typography variant="body6" color="textSecondary" component="p">
                                Category: {recipe.recipeCategory.name}
                            </Typography>
                        </CardContent>
                        <CardActions disableSpacing>
                            <IconButton aria-label="add to favorites">
                                <FavoriteIcon/>
                            </IconButton>
                            <IconButton aria-label="share">
                                <ShareIcon/>
                            </IconButton>
                            <IconButton
                                className={clsx(classes.expand, {
                                    [classes.expandOpen]: expanded,
                                })}
                                onClick={handleExpandClick}
                                aria-expanded={expanded}
                                aria-label="show more">
                                <ExpandMoreIcon/>
                            </IconButton>
                        </CardActions>
                        <Collapse in={expanded} timeout="auto" unmountOnExit>
                            <CardContent>
                                <Typography paragraph>Description:</Typography>
                                <Typography variant="body2" color="textSecondary" component="p">
                                    {props.recipe.description}
                                </Typography>
                                <br/><br/>
                                <Typography>
                                    <Typography paragraph>Ingredients:</Typography>
                        <span>
                            {recipe.ingredients.map((ingredient, index) => {
                                return <div key={index}>
                                    <Typography variant="body2" color="textSecondary" component="p">
                                        {ingredient.name}
                                        {ingredient.spicy}
                                    </Typography>
                                </div>
                            })}
                        </span>
                                </Typography>
                            </CardContent>
                        </Collapse>
                    </Card>
                </div> :
                <div style={{display: 'flex', justifyContent: 'center', alignItems: 'center', height: '50vh'}}
                     className="container text-black-50 text-lg-center">
                    <img alt="" style={{width: "10%"}}
                         src={require('../../../assets/loading.gif')}/>
                    Please wait while we fetch our data
                </div>}
            <br/>
        </div>

    );
}
export default RecipeDetails;