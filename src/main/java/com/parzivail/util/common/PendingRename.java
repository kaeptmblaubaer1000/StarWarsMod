package com.parzivail.util.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This annotation marks elements that should get renamed at some point.
 * {@link #value()}/{@link Kind} denote which rename they will get then.
 * Once you want to do the rename, just mark the corresponding {@link Kind} with
 * {@link Deprecated} and you will get all occurrences of it marked in your IDE.
 * {@link Deprecated} can also be used on a {@link Kind} to denote that
 * the rename is in progress and will soon be finished, just like
 * {@link Deprecated} is used to mark elements that will soon get removed.
 */
@Retention(RetentionPolicy.SOURCE)
public @interface PendingRename
{
	enum Kind {
		FORCE_XP
	}

	Kind value();
}
