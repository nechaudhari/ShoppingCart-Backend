package com.neha.ShoppingCart.controller.customer;

import com.neha.ShoppingCart.dto.AddProductInCartDto;
import com.neha.ShoppingCart.dto.OrderDto;
import com.neha.ShoppingCart.services.Customer.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;


    @PostMapping("/cart")
    public ResponseEntity<?> addProductToCart(@RequestBody AddProductInCartDto addProductInCartDto){
        try {
            return ResponseEntity.ok(cartService.addProductToCart(addProductInCartDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while adding the product to the cart.");
        }
    }

    @GetMapping("/cart/{userId}")
    public ResponseEntity<?> getCartByUserId(@PathVariable Long userId){
//        OrderDto orderDto = cartService.getCartByUserId(userId);
//        return ResponseEntity.status(HttpStatus.OK).body(orderDto);
        try {
            OrderDto orderDto = cartService.getCartByUserId(userId);
            return ResponseEntity.status(HttpStatus.OK).body(orderDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching the cart.");
        }
    }
}
