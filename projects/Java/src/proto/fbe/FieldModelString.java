// Automatically generated by the Fast Binary Encoding compiler, do not modify!
// https://github.com/chronoxor/FastBinaryEncoding

package fbe;

import java.io.*;
import java.lang.*;
import java.lang.reflect.*;
import java.math.*;
import java.nio.charset.*;
import java.time.*;
import java.util.*;

// Fast Binary Encoding string field model class
public final class FieldModelString extends FieldModel
{
    public FieldModelString(Buffer buffer, long offset) { super(buffer, offset); }

    // Get the field size
    @Override
    public long fbeSize() { return 4; }
    // Get the field extra size
    @Override
    public long fbeExtra()
    {
        if ((_buffer.getOffset() + fbeOffset() + fbeSize()) > _buffer.getSize())
            return 0;

        int fbeStringOffset = readInt32(fbeOffset());
        if ((fbeStringOffset == 0) || ((_buffer.getOffset() + fbeStringOffset + 4) > _buffer.getSize()))
            return 0;

        int fbeStringSize = readInt32(fbeStringOffset);
        return 4 + fbeStringSize;
    }

    // Check if the string value is valid
    @Override
    public boolean verify()
    {
        if ((_buffer.getOffset() + fbeOffset() + fbeSize()) > _buffer.getSize())
            return true;

        int fbeStringOffset = readInt32(fbeOffset());
        if (fbeStringOffset == 0)
            return true;

        if ((_buffer.getOffset() + fbeStringOffset + 4) > _buffer.getSize())
            return false;

        int fbeStringSize = readInt32(fbeStringOffset);
        if ((_buffer.getOffset() + fbeStringOffset + 4 + fbeStringSize) > _buffer.getSize())
            return false;

        return true;
    }

    // Get the string value
    public String get() { return get(""); }
    public String get(String defaults)
    {
        assert (defaults != null) : "Invalid default string value!";
        if (defaults == null)
            throw new IllegalArgumentException("Invalid default string value!");

        String value = defaults;

        if ((_buffer.getOffset() + fbeOffset() + fbeSize()) > _buffer.getSize())
            return value;

        int fbeStringOffset = readInt32(fbeOffset());
        if (fbeStringOffset == 0)
            return value;

        assert ((_buffer.getOffset() + fbeStringOffset + 4) <= _buffer.getSize()) : "Model is broken!";
        if ((_buffer.getOffset() + fbeStringOffset + 4) > _buffer.getSize())
            return value;

        int fbeStringSize = readInt32(fbeStringOffset);
        assert ((_buffer.getOffset() + fbeStringOffset + 4 + fbeStringSize) <= _buffer.getSize()) : "Model is broken!";
        if ((_buffer.getOffset() + fbeStringOffset + 4 + fbeStringSize) > _buffer.getSize())
            return value;

        value = readString(fbeStringOffset + 4, fbeStringSize);
        return value;
    }

    // Set the string value
    public void set(String value)
    {
        assert (value != null) : "Invalid string value!";
        if (value == null)
            throw new IllegalArgumentException("Invalid string value!");

        assert ((_buffer.getOffset() + fbeOffset() + fbeSize()) <= _buffer.getSize()) : "Model is broken!";
        if ((_buffer.getOffset() + fbeOffset() + fbeSize()) > _buffer.getSize())
            return;

        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);

        int fbeStringSize = bytes.length;
        int fbeStringOffset = (int)(_buffer.allocate(4 + fbeStringSize) - _buffer.getOffset());
        assert ((fbeStringOffset > 0) && ((_buffer.getOffset() + fbeStringOffset + 4 + fbeStringSize) <= _buffer.getSize())) : "Model is broken!";
        if ((fbeStringOffset <= 0) || ((_buffer.getOffset() + fbeStringOffset + 4 + fbeStringSize) > _buffer.getSize()))
            return;

        write(fbeOffset(), fbeStringOffset);
        write(fbeStringOffset, fbeStringSize);
        write(fbeStringOffset + 4, bytes);
    }
}
