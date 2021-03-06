// Automatically generated by the Fast Binary Encoding compiler, do not modify!
// https://github.com/chronoxor/FastBinaryEncoding

package enums.fbe;;

import java.io.*;
import java.lang.*;
import java.lang.reflect.*;
import java.math.*;
import java.nio.charset.*;
import java.time.*;
import java.util.*;

import fbe.*;
import enums.*;

import com.google.gson.*;

public final class EnumByteJson implements JsonSerializer<EnumByte>, JsonDeserializer<EnumByte>
{
    @Override
    public JsonElement serialize(EnumByte src, Type typeOfSrc, JsonSerializationContext context)
    {
        return new JsonPrimitive(src.getRaw());
    }

    @Override
    public EnumByte deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException
    {
        return new EnumByte(json.getAsJsonPrimitive().getAsByte());
    }
}
