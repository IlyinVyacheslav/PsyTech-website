<template>
    <article>
        <div class="title">{{ post.title }}</div>
        <div class="information">By {{ post.user.name }}, {{ post.creationTime }}</div>
        <div class="body">{{ post.text }}</div>
        <div class="footer">
            <div class="right">
                {{ post.creationTime }}
                <!--                <a href="<@spring.url '/post/${post.id}'/>">${post.comments?size}</a>-->
            </div>
        </div>
    </article>
</template>

<script>
export default {
    name: "ArticlePost",
    props: ["post"]
}
</script>

<style scoped>

</style>