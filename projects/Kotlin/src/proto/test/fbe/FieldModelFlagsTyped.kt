// Automatically generated by the Fast Binary Encoding compiler, do not modify!
// https://github.com/chronoxor/FastBinaryEncoding

package test.fbe;

import java.io.*;
import java.lang.*;
import java.lang.reflect.*;
import java.math.*;
import java.nio.charset.*;
import java.time.*;
import java.util.*;

import fbe.*;
import test.*;

// Fast Binary Encoding FlagsTyped field model class
class FieldModelFlagsTyped(buffer: Buffer, offset: Long) : FieldModel(buffer, offset)
{
    // Field size
    override val FBESize: Long = 8

    // Get the value
    fun get(defaults: FlagsTyped = FlagsTyped()): FlagsTyped {
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return defaults

        return FlagsTyped(readUInt64(FBEOffset))
    }

    // Set the value
    fun set(value: FlagsTyped) {
        assert(_buffer.offset + FBEOffset + FBESize <= _buffer.size) { "Model is broken!" }
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return

        write(FBEOffset, value.raw)
    }
}