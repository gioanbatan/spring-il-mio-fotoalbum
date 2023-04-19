<script>
import axios from 'axios';
import AppPhotoCard from "../components/AppPhotoCard.vue";


export default {
    name: 'HomePage',
    components: {
        AppPhotoCard
    },
    data() {
        return {
            photos: [],
        }
    },
    created() {
        this.getPhotos();
    },
    methods: {
        getPhotos() {
            axios.get('http://127.0.0.1:8080/api/v1/photos').then(resp => {
                console.log(resp);
                this.photos = resp.data;
            });
        }
    }
}
</script>

<template>
    <main class="ms_main-container">
        <div class="container">
            <div class="row g-3">
                <div class="col" v-for="photo in photos">
                    <AppPhotoCard :photo="photo" :key="photo.id" />
                </div>
            </div>
        </div>
    </main>
</template>

<style lang="scss" scoped>
@use "../style/general.scss" as *;
@use "../style/partials/variables" as *;

main {
    background-image: url("../../public/images/img_2.jpg");
    background-size: cover;
    background-position: center;
    background-attachment: fixed;

    padding-top: calc(1rem + $header-height);
    padding-bottom: calc(1rem + $footer-height);
}
</style>