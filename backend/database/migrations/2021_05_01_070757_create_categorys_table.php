<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreatecategorysTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('categorys', function (Blueprint $table) {
            $table->tinyInteger('id',true);
            $table->string('name', 20);
            $table->string('url', 30);
            $table->tinyInteger('status')->default('1');
            $table->timestamps();
        });
        Schema::table('categorys', function (Blueprint $table) {
            $table->tinyInteger('categorys_id')->nullable();
            $table->foreign('categorys_id')->references('id')->on('categorys');


            $table->integer('create_by');
            $table->integer('update_by');

            $table->foreign('create_by')->references('id')->on('users');
            $table->foreign('update_by')->references('id')->on('users');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('categorys');
    }
}
