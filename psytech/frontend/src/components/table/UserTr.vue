<template>
    <tr>
        <td class="id">{{ user.id }}</td>
        <td class="login">{{ user.email }}</td>
        <td class="name">{{ user.name }}</td>
    </tr>
</template>

<script>
export default {
    name: "UserTr",
    props: ["user"]
}
</script>

<style scoped>

</style>