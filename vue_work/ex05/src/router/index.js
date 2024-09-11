import TheAbout from '@/views/TheAbout.vue';
import TheHome from '@/views/TheHome.vue';
import TheJoin from '@/views/TheJoin.vue';
import {createRouter, createWebHashHistory} from 'vue-router';

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        { path:'/', component: TheHome},
        { path:'/join', component: TheJoin},
        { path:'/about', component: TheAbout},
    ]
});


export default router;