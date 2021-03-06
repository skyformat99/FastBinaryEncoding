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

// Fast Binary Encoding enums receiver class
public class Receiver extends fbe.Receiver
{
    // Receiver values accessors
    private final enums.Enums EnumsValue;

    // Receiver models accessors
    private final EnumsModel EnumsModel;

    public Receiver()
    {
        EnumsValue = new enums.Enums();
        EnumsModel = new EnumsModel();
    }
    public Receiver(Buffer buffer)
    {
        super(buffer);
        EnumsValue = new enums.Enums();
        EnumsModel = new EnumsModel();
    }

    // Receive handlers
    protected void onReceive(enums.Enums value) {}

    @Override
    public boolean onReceive(long type, byte[] buffer, long offset, long size)
    {
        switch ((int)type)
        {
            case (int)enums.fbe.EnumsModel.fbeTypeConst:
            {
                // Deserialize the value from the FBE stream
                EnumsModel.attach(buffer, offset);
                assert EnumsModel.verify() : "enums.Enums validation failed!";
                long deserialized = EnumsModel.deserialize(EnumsValue);
                assert (deserialized > 0) : "enums.Enums deserialization failed!";

                // Log the value
                if (getLogging())
                {
                    String message = EnumsValue.toString();
                    onReceiveLog(message);
                }

                // Call receive handler with deserialized value
                onReceive(EnumsValue);
                return true;
            }
        }

        return false;
    }
}
