import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/api/";

const getAllProducts = () => {
  return axios.get(API_URL + "inventory/all", { headers: authHeader() });
};


export default {
    getAllProducts
};