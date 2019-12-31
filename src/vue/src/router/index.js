import Vue from 'vue'
import VueRouter from 'vue-router'
import Article from '@/views/Article.vue'


Vue.use(VueRouter)

const routes = [{
        path: '/',
        component: () =>
            import ('@/views/Home.vue')
    },
    {
        path: '/about',
        component: () =>
            import ( /* webpackChunkName: "about" */ '@/views/About.vue')
    },
    {
        path: '/login',
        component: () =>
            import ('@/views/Login.vue')
    },
    {
        path: '/articles/:id',
        component: Article
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router