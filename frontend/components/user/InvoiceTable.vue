<template>
  <v-container>
    <v-row v-show="invoice.length === 0">
      <v-col>
        <v-img
          contain
          max-height="250"
          width="100%"
          position="top center"
          :src="require('@/assets/logo/404.svg')"
        />
      </v-col>
    </v-row>
    <v-row v-show="invoice.length > 0">
      <v-col>
        <v-simple-table fixed-header height="300px">
          <thead>
            <tr>
              <th class="text-left">Mã đơn hàng</th>
              <th class="text-left">Sản phẩm</th>
              <th class="text-left">Số lượng</th>
              <th class="text-left">Đơn giá</th>
              <th class="text-left">Tổng tiền</th>
              <th class="text-left">Ngày đặt hàng hàng</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="item in invoice" :key="item.name">
              <td>{{ item.billCode }}</td>
              <td>{{ item.name }}</td>
              <td>{{ item.amount }}</td>
              <td>
                {{ parseInt(item.price).toLocaleString() }}
                {{ $local.vn.currency }}
              </td>
              <td>
                {{ parseInt(item.price * item.amount).toLocaleString() }}
                {{ $local.vn.currency }}
              </td>
              <td>{{ item.createDate.slice(0, 10) }}</td>
            </tr>
          </tbody>
        </v-simple-table>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  props: ['invoice'],
}
</script>

<style lang="scss" scoped></style>
