import axios from 'axios'
export default {
    all() {
        return axios.get('http://localhost:8080/articles');
    },
    publish(article) {
        return axios.post('http://localhost:8080/articles', article);
    },
    findById(articleId) {
        return axios.get(`http://localhost:8080/articles/${articleId}`);
    }
}