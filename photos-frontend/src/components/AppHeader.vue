<script>
</script>

<template>
    <nav class="navbar navbar-dark ms_nav navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Photos</a>

            <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
                aria-controls="offcanvasNavbar" aria-label="Toggle navigation"><span
                    class="navbar-toggler-icon"></span></button>

            <div class="offcanvas offcanvas-end text-bg-dark" data-bs-scroll="true" data-bs-backdrop="true" tabindex="-1"
                id="offcanvasNavbar" aria-labelledby="offcanvasScrollingLabel">
                <div class="offcanvas-header">
                    <h5 class="offcanvas-title" id="offcanvasScrollingLabel">Photos</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Categories</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</template>

<style lang="scss" scoped>
@use "../style/partials/variables" as *;

.ms_nav {
    width: 100%;
    min-height: $header-height;
    background-color: $header-bg;
    box-shadow: 0 4px 0 $header-shadow;
    color: $header-text;
    position: fixed;
    top: 0;
    left: 0;

    z-index: 999;
}
</style>