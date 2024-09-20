import TheAbout from '@/views/TheAbout.vue';
import TheHome from '@/views/TheHome.vue';
import TheJoin from '@/views/TheJoin.vue';
import {createRouter, createWebHashHistory} from 'vue-router';
import TheFreeBoardInput from '@/views/freeboard/TheFreeBoardInput.vue';
import TheFreeBoardList from '@/views/freeboard/TheFreeBoardList.vue';
import TheFreeBoardView from '@/views/freeboard/TheFreeBoardView.vue';

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        { path:'/', component: TheHome},
        { path:'/join', component: TheJoin},
        { path:'/about', component: TheAbout},
        { path:'/freeboardInput', component: TheFreeBoardInput},
        { path:'/freeboardSelect', component: TheFreeBoardList},
        { path:'/freeboardView/:idx', component: TheFreeBoardView},
    ]
});


export default router;