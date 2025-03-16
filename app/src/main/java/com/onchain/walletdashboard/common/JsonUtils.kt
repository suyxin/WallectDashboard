package com.onchain.walletdashboard.common



import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object JsonUtils {


    /**
     * 将 JSON 字符串转换为指定类型的 Kotlin 对象
     *
     * @param json JSON 字符串
     * @param clazz 目标对象的 Class
     * @return 目标对象实例
     */
    inline fun <reified T> fromJson(json: String, clazz: Class<T>): T {
        return Gson().fromJson(json, clazz)
    }

    /**
     * 将 JSON 字符串转换为指定类型的 Kotlin 对象列表
     *
     * @param json JSON 字符串
     * @return 目标对象列表
     */
    inline fun <reified T> fromJsonList(json: String): List<T> {
        val type: Type = object : TypeToken<List<T>>() {}.type
        return Gson().fromJson(json, type)
    }

    /**
     * 将 Kotlin 对象转换为 JSON 字符串
     *
     * @param obj 目标对象实例
     * @return JSON 字符串
     */
    fun toJson(obj: Any): String {
        return Gson().toJson(obj)
    }

    /**
     * 将 Kotlin 对象列表转换为 JSON 字符串
     *
     * @param list 目标对象列表
     * @return JSON 字符串
     */
    fun toJsonList(list: List<Any>): String {
        return Gson().toJson(list)
    }

}