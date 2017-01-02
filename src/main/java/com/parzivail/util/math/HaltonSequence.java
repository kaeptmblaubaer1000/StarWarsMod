package com.parzivail.util.math;

import com.parzivail.util.lwjgl.Vector3f;

/**
 * Created by colby on 1/2/2017.
 */
public class HaltonSequence
{
	public Vector3f mCurrentPos = new Vector3f(0.0f, 0.0f, 0.0f);
	long _mBase2;
	long _mBase3;
	long _mBase5;
	static final float fOneOver3 = 1.0f / 3.0f;
	static final float fOneOver5 = 1.0f / 5.0f;

	public long increment()
	{
		long oldBase2 = _mBase2;
		_mBase2++;
		long diff = _mBase2 ^ oldBase2;

		float s = 0.5f;

		do
		{
			if ((oldBase2 & 1) == 1)
				mCurrentPos.x -= s;
			else
				mCurrentPos.x += s;

			s *= 0.5f;

			diff = diff >> 1;
			oldBase2 = oldBase2 >> 1;
		}
		while (diff > 0);

		long bitmask = 0x3;
		long bitadd = 0x1;
		s = fOneOver3;

		_mBase3++;

		while (true)
		{
			if ((_mBase3 & bitmask) == bitmask)
			{
				_mBase3 += bitadd;
				mCurrentPos.y -= 2 * s;

				bitmask = bitmask << 2;
				bitadd = bitadd << 2;

				s *= fOneOver3;
			}
			else
			{
				mCurrentPos.y += s;
				break;
			}
		}
		bitmask = 0x7;
		bitadd = 0x3;
		long dmax = 0x5;

		s = fOneOver5;

		_mBase5++;

		while (true)
		{
			if ((_mBase5 & bitmask) == dmax)
			{
				_mBase5 += bitadd;
				mCurrentPos.z -= 4 * s;

				bitmask = bitmask << 3;
				dmax = dmax << 3;
				bitadd = bitadd << 3;

				s *= fOneOver5;
			}
			else
			{
				mCurrentPos.z += s;
				break;
			}
		}

		return _mBase2;
	}

	public void reset()
	{
		mCurrentPos.x = 0.0f;
		mCurrentPos.y = 0.0f;
		mCurrentPos.z = 0.0f;
		_mBase2 = 0;
		_mBase3 = 0;
		_mBase5 = 0;
	}
}
