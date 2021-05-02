<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateProductsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('products', function (Blueprint $table) {
            $table->integer('id', true);
            $table->string('name', 50);
            $table->BigInteger('price')->default('100000');
            $table->boolean('new')->default('0');
            $table->boolean('hot')->default('0');
            $table->text('info')->nullable();
            $table->string('small_info');
            $table->string('url', 60);
            $table->tinyInteger('status')->size('1')->default('1');
            $table->timestamps();
        });
        Schema::table('products', function (Blueprint $table) {

            $table->integer('create_by');
            $table->integer('update_by');

            $table->foreign('create_by')->references('id')->on('users');
            $table->foreign('update_by')->references('id')->on('users');

            $table->tinyInteger('categorys_id');

            $table->foreign('categorys_id')->references('id')->on('categorys');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('products');
    }
}
