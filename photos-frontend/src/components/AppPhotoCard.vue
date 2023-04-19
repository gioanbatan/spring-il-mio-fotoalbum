<script>

export default {
    name: "AppPhotoCard",
    compoments: {
    },
    data() {
        return {
        }
    },
    props: {
        photo: Object,
    }
}
</script>

<template>
    <div class="ms_card rounded" style="width: 18rem;">
        <img :src="`http://127.0.0.1:8080${photo.url}`" class="card-img-top rounded-top" :alt="photo.title">
        <div class="card-body bg-dark rounded-bottom p-3">
            <h5 class="card-title bg-dark text-light">{{ photo.title }}</h5>
            <p class="card-text bg-dark text-light">{{ photo.description }}</p>
            <a href="#" class="btn btn-secondary">Go somewhere</a>
        </div>
    </div>
</template>

<style lang="scss" scoped></style>
