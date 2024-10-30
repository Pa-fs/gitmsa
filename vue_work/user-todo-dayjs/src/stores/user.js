import { login } from '@/api/loginApi';
import { defineStore } from 'pinia';

export const useUserStore = defineStore('user', {
    state: () => ({
        loginCheck: false,
        nickName: '',
        thumbnail: '',
        profileImage: '',
        email: '',
    }),
    actions: {
        login(data) {
            // login 성공 ...
            // backend 통신 ...
            this.loginCheck = true;
            this.nickName = data.nickName;
            this.thumbnail = data.thumbnail;
            this.profileImage = data.profileImage;
            this.email = data.email;
        },
        logout() {
            this.loginCheck = false;
            this.nickName = '';
            this.thumbnail = '';
            this.profileImage = '';
            this.email = '';
        }
    },
});

