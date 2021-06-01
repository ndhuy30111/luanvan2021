<template>
  <b-container fluid>
    <b-row>
      <div class="col-lg-6 col-md-12 col-sm-12">
        <img
          class="img"
          src="https://cdn.shopify.com/s/files/1/2598/7400/products/012_grande.jpg?v=1514365627"
          width="100%"
          height="100%"
          alt="img product"
        />
      </div>

      <div class="col-lg-6 col-md-12 col-sm-12">
        <div class="wrapper">
          <div class="outer">
            <div class="content">
              <span class="product__content">Tên sp</span>

              <div class="colors-wrap">
                <h6>Màu sắc:</h6>
                <span class="colors" style="background-color: red"></span>
                <span
                  class="colors selected"
                  style="background-color: black"
                ></span>
                <span class="colors" style="background-color: blue"></span>
              </div>

              <div class="size-wrap">
                <h6>Kích cỡ:</h6>
                <span class="size selected">S</span>
                <span class="size">M</span>
              </div>
              <div class="size-wrap">
                <h6>Số lượng:</h6>
                <b-form-input
                  id="input-amount"
                  v-model="quantity"
                  type="number"
                  min="1"
                  style="width: 70px; margin-left: 20px"
                  >{{ quantity }}</b-form-input
                >
              </div>

              <div class="button">
                <span>
                  <a href="#"> 10000000 đ</a>
                  <a class="cart-btn">
                    <b-icon icon="cart"></b-icon> Thêm vào giỏ</a
                  >
                </span>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div></div>
    </b-row>
  </b-container>
</template>

<script>
export default {
  name: 'Productdetail',
  data() {
    return {
      quantity: 1,
    }
  },
}
</script>

<style scoped>
.wrapper {
  display: flex;
  align-items: center;
  justify-content: space-around;
  width: 100%;
  height: 60vh;
  margin-top: 10%;
}
.outer {
  position: relative;
  background-color: #fff;
  height: 100%;
  width: 100%;
  overflow: hidden;
  display: flex;
  align-items: center;
  border-radius: 10px;
  margin-top: -40px;
}
p {
  width: 280px;
  font-size: 13px;
  line-height: 1.4;
  color: #aaa;
  margin: 20px 0;
}
.img {
  /* position: absolute; */
  top: 0px;
  right: 0px;
  width: 100%;
  margin-top: -15px;
  height: 85%;
}
.content {
  position: relative;
  left: 20px;
  z-index: 3;
  margin-top: -20%;
  text-align: left;
}
.bg {
  display: inline-block;
  overflow: hidden;
  position: relative;
  font-size: 15px;

  color: #fff;
  background-color: red;
  text-decoration: none;
  padding: 10px 10px;
  border: 1px solid #aaa;
  font-weight: bold;
  border-radius: 25px;
}
.button {
  width: fit-content;
  height: fit-content;
  margin-top: 5px;
}
.button a {
  display: inline-block;
  overflow: hidden;
  position: relative;
  font-size: 14px;
  color: #111;
  text-decoration: none;
  padding: 8px 8px;
  border: 1px solid #aaa;
  font-weight: bold;
}
.button a:after {
  content: '';
  position: absolute;
  top: 0;
  right: -10px;
  width: 0%;
  background-color: black;
  height: 100%;
  z-index: -1;
  transition: width 0.3s ease-in-out;
  transform: skew(-25deg);
  transform-origin: right;
}
.product__content {
  font-size: 2.5em;
}
.button a:hover:after {
  width: 150%;
  left: -10px;
  transform-origin: left;
}
.button a:hover {
  color: #fff;
  transition: all 0.5s ease;
}
.button a:nth-of-type(1) {
  border-radius: 50px 0 0 50px;
  border-right: none;
}
.button a:nth-of-type(2) {
  border-radius: 0px 50px 50px 0;
}
.cart-icon {
  padding-right: 8px;
}
@media (max-width: 768px) {
  .wrapper {
    margin: -125px 0px 0px -35px;
  }
  .outer {
    width: 95%;
    margin-top: 0;
  }
  .content {
    left: 50%;
    transform: translateX(-40%);
  }

  .img {
    /* display: none; */
    width: 100%;
    margin-top: 0px !important;
  }
  .product__content {
    font-size: 1em;
  }
}
.colors {
  width: 20px;
  height: 20px;
  display: inline-block;
  transition: 0.3s all;
  border-radius: 50%;
  border: 1px solid black;
  margin: 0 15px;
}
.colors:hover,
.size:hover {
  transform: scale(1.2);
  box-shadow: 0 0 0 8px rgba(173, 173, 170, 0.3);
  cursor: pointer;
}
.colors:active,
.size:active {
  transform: scale(0.8);
}
.selected {
  box-shadow: 0 0 0 4px #fff, 0 0 0 8px rgba(173, 173, 170, 0.3);
}
.colors-wrap,
.size-wrap {
  width: 100%;
  height: auto;
  margin: 5px auto;
  padding: 10px;
  border-radius: 70px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
}
.size {
  border-radius: 50%;
  width: 30px;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 0 15px;
  cursor: pointer;
  transition: all 0.3s;
}
.sameproduct {
  margin-top: -10%;
}
</style>
