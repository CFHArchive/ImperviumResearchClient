package icac.irc.client.datatypes;

public enum VariantType {
	NULL((byte)1),
	DOUBLE((byte)2),
	BOOL((byte)3),
	VLQ((byte)4),
	STRING((byte)5),
	VARIANTARRAY((byte)6),
	DICTIONARY((byte)7);
	
	byte type;
	
	VariantType(byte type)
	{
		this.type = type;
	}
	public static VariantType findByType(byte type)
	{
		switch (type)
		{
			case 2:
				return DOUBLE;
			case 3:
				return BOOL;
			case 4:
				return VLQ;
			case 5:
				return STRING;
			case 6:
				return VARIANTARRAY;
			case 7:
				return DICTIONARY;
			default:
				return NULL;
		}
	}
}