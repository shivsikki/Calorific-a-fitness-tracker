import axios from "axios";

const API_BASE_URL = "http://localhost:8080";

const ApiService = {
    registerUser: async (userData) => {
        return axios.post(`${API_BASE_URL}/api/users/register`, userData);
    },

    loginUser: async (credentials) => {
        return axios.post(`${API_BASE_URL}/api/users/login`, credentials)
            .then(response => response.data);
    }
};

export default ApiService;
