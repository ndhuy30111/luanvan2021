<template>
  <div>
    <v-row>
      <v-spacer></v-spacer>
      <v-col cols="2">
        <v-select v-model="select" :items="selects" chips flat solo></v-select>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: 'Filter1',
  data: () => {
    return {
      select: null,
      selects: [
        'Giá tăng',
        'Giá giảm',
        'Tên: A - Z',
        'Tên: Z - A',
        'Mới nhất',
        'Bán chạy nhất',
        'Cũ nhất',
      ],
    }
  },
}
</script>

<style lang="scss" scoped></style>
