package com.parzivail.util.network;

import com.parzivail.util.common.Nullable;
import javax.annotation.meta.TypeQualifierNickname;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@TypeQualifierNickname
@Nullable
public @interface OptionalField
{
}
