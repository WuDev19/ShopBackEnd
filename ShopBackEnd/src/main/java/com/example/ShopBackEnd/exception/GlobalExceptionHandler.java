package com.example.ShopBackEnd.exception;

import com.example.ShopBackEnd.dto.get.ExceptionResponseDTO;
import com.example.ShopBackEnd.exception.customexception.PageNumberNegativeException;
import com.example.ShopBackEnd.exception.customexception.ResourcesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*extends ResponseEntityExceptionHandler để override xử lý exception mà spring cài đặt sẵn,
    ví dụ những exception khi dùng @Valid
*/

//sử dụng chuẩn restful
//@ControllerAdvice thì phù hợp với tạo view Html
@RestControllerAdvice // = @ControllerAdvice + @ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(PageNumberNegativeException.class) //khai báo annotation để bắt exception này phục vụ xử lý chung
    public ResponseEntity<ExceptionResponseDTO> handlePageNumberNegativeException(PageNumberNegativeException e) {
        System.out.println(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponseDTO(
                        HttpStatus.BAD_REQUEST.value(),
                        e.getMessage()
                ));
    }

    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleResourcesNotFoundException(ResourcesNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponseDTO(
                        HttpStatus.NOT_FOUND.value(),
                        e.getMessage()
                ));
    }

    @ExceptionHandler(ClassCastException.class)
    public ResponseEntity<ExceptionResponseDTO> handleClassCastException(ClassCastException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionResponseDTO(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        e.getMessage()
                ));
    }


}
