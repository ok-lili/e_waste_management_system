import axios from 'axios';
const API_URL = "http://localhost:8080/api/categories";

const getCateogories = () => {
    return axios.get(API_URL);
}
const createCatgory = (category) => axios.post(API_URL, category);
export default {
    getCateogories,
    createCatgory
};