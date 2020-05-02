package com.parzivail.util.common;

import javax.annotation.meta.TypeQualifierNickname;
import java.lang.annotation.*;

@Documented
@TypeQualifierNickname
@javax.annotation.Nullable
@Retention(RetentionPolicy.RUNTIME)
@Target({
		        ElementType.ANNOTATION_TYPE,
		        ElementType.FIELD,
		        ElementType.LOCAL_VARIABLE,
		        ElementType.METHOD,
		        ElementType.PARAMETER
        })
public @interface Nullable
{
}
