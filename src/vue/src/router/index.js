import Vue from 'vue'
import VueRouter from 'vue-router'
import About from '@/views/About.vue'

Vue.use(VueRouter)

const routes = [{
        path: '/',
        name: 'main',
        component: () =>
            import ('@/views/Home.vue')
    },
    {
        path: '/about',
        name: 'about',
        component: About
    },
    {
        path: '/login',
        name: 'login',
        component: () =>
            import ('@/views/Login.vue')
    },
    {
        path: '/articles/new',
        name: 'newArticle',
        component: () =>
            import ('@/views/NewArticle.vue')
    },
    {
        path: '/articles/:articleId',
        name: 'article',
        component: () =>
            import ('@/views/Article.vue'),
        props: true
    },
    {
        path: '*',
        redirect: '/'
    },

]
const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router