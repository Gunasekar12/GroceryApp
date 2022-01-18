package com.example.groceryapp.model

import android.icu.text.AlphabeticIndex
import com.example.groceryapp.Records
import java.util.*
import kotlin.collections.ArrayList

data class getgroceryresponse(val created:Int?=0, val updated:Int?=0,
                              val active:String, val index_name:String, val org:ArrayList<String>, val org_type:String, val source:String,
                              val title:String, val external_ws_url:String?="", val visualizable:String, val field:ArrayList<Field>,
                              val  external_ws:Int?=0, val catalog_uuid:String, val sector:ArrayList<String>, val target_bucket:Array<Target_bucket>,
                              val desc:String, val message:String, val version:String, val status:String, val total:Int?=0, val count:Int?=0,
                              val limit:String, val offset:String, val records:ArrayList<Records>

                              )
