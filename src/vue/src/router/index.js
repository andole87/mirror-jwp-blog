import Vue from 'vue'
import VueRouter from 'vue-router'
import Article from '@/views/Article.vue'


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
        component: () =>
            import ( /* webpackChunkName: "about" */ '@/views/About.vue')
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
        path: '/articles/:id',
        name: 'article',
        component: Article,
        props: true
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router