import axios from 'axios'
export default {
    all() {
        return axios.get('http://localhost:8080/articles');
    }
}