package com.LayShare.LayShare.user;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
@Target({FIELD}) // Bu annotationu nerde kullanacağımızı belirtiyoruz
@Retention(RUNTIME) // Annotationun runetime de çözümlenmesi
@Constraint(validatedBy = { UniqueUsernameValidator.class })//  // Annotaationun kullanıldığı yerlerde uygulanacak olan validation logicin ilgili muhatap classı
public @interface UniqueUsername {

    String message() default "{LayShare.constraint.username.UniqueUsername.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
