package com.example.enterpriceAPI.service

import com.example.enterpriceAPI.model.orderItem
import com.example.enterpriceAPI.repository.orderItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class orderItemService {
    @Autowired
lateinit var orderItemRepository: orderItemRepository

    fun list(): List<orderItem> {
        return orderItemRepository.findAll()
    }

    fun save(orderItem: orderItem):orderItem {
        return orderItemRepository.save(orderItem)
    }

    fun update(orderItem: orderItem):orderItem{
        try {
            orderItemRepository.findById(orderItem.id)?:throw Exception("Articulo no Encontrado")
            return orderItemRepository.save(orderItem)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateOrder(orderItem: orderItem):orderItem{
        try {
            var reponse = orderItemRepository.findById(orderItem.id)?: throw  Exception("Ya Existe el Id")
                reponse.apply {
                    order=orderItem.order
                }
            return orderItemRepository.save(reponse)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }


    fun delete(id: Long){
        try {
            var response = orderItemRepository.findById(id).orElseThrow{throw  ResponseStatusException(HttpStatus.NOT_FOUND,"Pais no encontrado con el Id: $id")}
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al Eliminar el Articulo",ex)
        }
    }

}