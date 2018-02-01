package com.studio701.activity

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.util.MultiValueMap

fun post(url:String, mockMvc: MockMvc, content:Any):String{
    return mockMvc.perform(MockMvcRequestBuilders.post(
            url).contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(ObjectMapper().writeValueAsString(content)))
            .andExpect(MockMvcResultMatchers.status().isOk).andReturn().response.contentAsString
}
fun put(url:String, mockMvc:MockMvc, params:Map<String, String>?):String{
    return mockMvc.perform(MockMvcRequestBuilders
            .put(url)).andExpect(MockMvcResultMatchers.status().isOk).andReturn().response.contentAsString
}
fun get(url:String, mockMvc:MockMvc, params:Map<String, String>?):String{
    return mockMvc.perform(MockMvcRequestBuilders
            .get(url)).andExpect(MockMvcResultMatchers.status().isOk).andReturn().response.contentAsString
}
fun delete(url:String, mockMvc:MockMvc):String{
    return mockMvc.perform(MockMvcRequestBuilders
            .put(url)).andExpect(MockMvcResultMatchers.status().isOk).andReturn().response.contentAsString
}