// Automatically generated by the Fast Binary Encoding compiler, do not modify!
// https://github.com/chronoxor/FastBinaryEncoding

package enums.fbe;

import java.io.*;
import java.lang.*;
import java.lang.reflect.*;
import java.math.*;
import java.nio.charset.*;
import java.time.*;
import java.util.*;

import fbe.*;
import enums.*;

// Fast Binary Encoding enums sender class
public class Sender extends fbe.Sender
{
    // Sender models accessors
    public final EnumsModel EnumsModel;

    public Sender()
    {
        EnumsModel = new EnumsModel(getBuffer());
    }
    public Sender(Buffer buffer)
    {
        super(buffer);
        EnumsModel = new EnumsModel(getBuffer());
    }

    public long send(enums.Enums value)
    {
        // Serialize the value into the FBE stream
        long serialized = EnumsModel.serialize(value);
        assert (serialized > 0) : "enums.Enums serialization failed!";
        assert EnumsModel.verify() : "enums.Enums validation failed!";

        // Log the value
        if (getLogging())
        {
            String message = value.toString();
            onSendLog(message);
        }

        // Send the serialized value
        return sendSerialized(serialized);
    }

    // Send message handler
    @Override
    protected long onSend(byte[] buffer, long offset, long size) { throw new UnsupportedOperationException("enums.fbe.Sender.onSend() not implemented!"); }
}
