//login api calls , future me token yhi handle hoga 

import axios from 'axios';
const API_URL = 'http://localhost:8080/api/assets';

const AuthService = {
    async login(username, password) {
        const response = await axios.post(`${API_URL}/login`, {
            username,
            password
        });
        if (response.data.token) {
            localStorage.setItem('user', JSON.stringify(response.data));
        }
        return response.data;
    },
    logout() {
        localStorage.removeItem('user');
    },
    signup(username, email, password) {
        return axios.post(`${API_URL}/signup`, {
            username,
            email,
            password
        });
    },
    // getCurrentUser() {
    //     return JSON.parse(localStorage.getItem('user'));
    // }
    // isLoggedIn() {
    //     const user = this.getCurrentUser();
    //     return !! user && !!user.token;
    // }
    // getToken() {
    //     const user = this.getCurrentUser();
    //     return user?.token;
    // }
}
export default AuthService;
