/*
Copyright (c) 2003-2010 Sony Pictures Imageworks Inc., et al.
All Rights Reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are
met:
* Redistributions of source code must retain the above copyright
  notice, this list of conditions and the following disclaimer.
* Redistributions in binary form must reproduce the above copyright
  notice, this list of conditions and the following disclaimer in the
  documentation and/or other materials provided with the distribution.
* Neither the name of Sony Pictures Imageworks nor the names of its
  contributors may be used to endorse or promote products derived from
  this software without specific prior written permission.
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package org.OpenColorIO;
import org.OpenColorIO.*;
import java.nio.FloatBuffer;

public class PackedImageDesc extends ImageDesc
{
    public PackedImageDesc(FloatBuffer data, long width, long height, long numChannels)
    {
        super();
        create(data, width, height, numChannels);
    }
    public PackedImageDesc(FloatBuffer data, long width, long height, long numChannels,
                           long chanStrideBytes, long xStrideBytes, long yStrideBytes)
    {
        super();
        create(data, width, height, numChannels, chanStrideBytes, xStrideBytes, yStrideBytes);
    }
    protected PackedImageDesc(long impl) { m_impl = impl; }
    protected native void create(FloatBuffer data, long width, long height, long numChannels);
    protected native void create(FloatBuffer data, long width, long height, long numChannels,
                                 long chanStrideBytes, long xStrideBytes, long yStrideBytes);
    public native void dispose();
    protected void finalize() { dispose(); }
    public native FloatBuffer getData();
    public native long getWidth();
    public native long getHeight();
    public native long getNumChannels();
    public native long getChanStrideBytes();
    public native long getXStrideBytes();
    public native long getYStrideBytes();
    private long m_impl = 0;
    static
    {
        System.loadLibrary("JNIOpenColorIO");
    }
};
