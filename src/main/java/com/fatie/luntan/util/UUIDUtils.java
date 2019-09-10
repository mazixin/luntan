package com.fatie.luntan.util;

import java.util.UUID;

/**
 * @author Hxx
 */
public class UUIDUtils
{
	public static String getUUID()

	{
		return UUID.randomUUID().toString().replace("-", "");
	}
}
