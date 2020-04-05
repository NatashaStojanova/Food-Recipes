import React from 'react';
import axios from '../../axios/axios';

const AuthenticationService = {
    loginUser: (request) => {
        return axios.post('/login', request);
    },

    registerUser: (request) => {
        return axios.post( '/user/register', request);
    }

};

export default AuthenticationService;