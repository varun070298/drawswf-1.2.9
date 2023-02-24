/****************************************************************
 * Copyright (c) 2001, David N. Main, All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or
 * without modification, are permitted provided that the 
 * following conditions are met:
 *
 * 1. Redistributions of source code must retain the above 
 * copyright notice, this list of conditions and the following 
 * disclaimer. 
 * 
 * 2. Redistributions in binary form must reproduce the above 
 * copyright notice, this list of conditions and the following 
 * disclaimer in the documentation and/or other materials 
 * provided with the distribution.
 * 
 * 3. The name of the author may not be used to endorse or 
 * promote products derived from this software without specific 
 * prior written permission. 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY 
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A 
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE 
 * AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; 
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR 
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, 
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ****************************************************************/
package com.anotherbigidea.flash.writers;

import java.io.*;
import java.util.*;
import com.anotherbigidea.flash.*;
import com.anotherbigidea.flash.readers.*;
import com.anotherbigidea.flash.structs.*;
import com.anotherbigidea.flash.interfaces.*;
import com.anotherbigidea.util.Hex;

/**
 * An implementation of the SWFTagTypes interface that produces a debug dump
 */
public class SWFTagDumper implements SWFTagTypes, SWFShape, SWFText 
{
    protected PrintWriter writer;
    protected String dashes = "---------------";
    protected boolean dumpHex;
    protected String indent = "";
    protected boolean decompileActions = false;
    
    /** 
     * Dump to System.out
     * @param dumpHex if true then binary data will dumped as hex - otherwise skipped
     */
    public SWFTagDumper( boolean dumpHex, boolean decompileActions )
    {
        this( System.out, dumpHex, decompileActions );
    }
    
    /**
     * Dump to the given output stream
     * @param dumpHex if true then binary data will dumped as hex - otherwise skipped
     */
    public SWFTagDumper( OutputStream out, 
                         boolean dumpHex, 
                         boolean decompileActions )
    {
        writer = new PrintWriter( out );
        this.dumpHex = dumpHex;
        this.decompileActions = decompileActions;
    }
    
    public SWFTagDumper( PrintWriter writer, 
                         boolean dumpHex, 
                         boolean decompileActions )
    {
        this.writer = writer;
        this.dumpHex = dumpHex;
        this.decompileActions = decompileActions;
    }

    protected void println( String line )
    {
        writer.println( indent + line );
    }
    
    /**
     * SWFTags interface
     */    
    public void tag( int tagType, boolean longTag, byte[] contents ) 
        throws IOException
    {
        println( "Tag " + tagType + " length=" + contents.length );
        
        if( dumpHex )
        {
            Hex.dump( writer, contents, 0L, indent + "    ", false );
            println( dashes );
        }
    }

    /**
     * SWFHeader interface.
     */
    public void header( int version, long length,
                        int twipsWidth, int twipsHeight,
                        int frameRate, int frameCount ) throws IOException
    {
        println( "header: version=" + version + 
                 " length=" + length + " width=" + twipsWidth +
                 " height=" + twipsHeight + " rate=" + frameRate +
                 " frame-count=" + frameCount );
    }
    
    /**
     * SWFTagTypes interface
     */
    public void tagEnd() throws IOException
    {
        println( "end" );
        println( dashes );
    }

    /**
     * SWFTagTypes interface
     */
    public void tagStartSound( int soundId, SoundInfo info ) throws IOException
        println( "start-sound id=" + soundId + " " + info );
    
    /**
     * SWFTagTypes interface
     */
    public void tagSoundStreamHead( 
        printSoundStreamHead( "sound-stream-head", 
            playbackFrequency, playback16bit, playbackStereo,
    
    /**
     * SWFTagTypes interface
     */
    public void tagSoundStreamHead2( 
        printSoundStreamHead( "sound-stream-head-2", 
            playbackFrequency, playback16bit, playbackStereo,
    
    public void printSoundStreamHead( String name,
        if( playbackFrequency == SWFConstants.SOUND_FREQ_11KHZ ) playFreq = "11";
        if( streamFrequency == SWFConstants.SOUND_FREQ_11KHZ ) streamFreq = "11";
        if( streamFormat == SWFConstants.SOUND_FORMAT_ADPCM ) format = "ADPCM";
        println( name + " play at " + playFreq + "kHz stereo=" + playbackStereo +
                 " 16bit=" + playback16bit + " | Stream at " + streamFreq +
                 "kHz format=" + format + " stereo=" + streamStereo +
                 " 16bit=" + stream16bit + " Avg-Samples=" + averageSampleCount );
    
    
     * SWFTagTypes interface
     */
    public void tagSoundStreamBlock( byte[] soundData ) throws IOException
        println( "sound-stream-block" );
        
        if( dumpHex )
        {
            Hex.dump( writer, soundData, 0L, indent + "    ", false );
            println( dashes );
        }        
     * SWFTagTypes interface
     */
    public void tagSerialNumber( String serialNumber ) throws IOException
        println( "serial number =" + serialNumber );       
                                                              
     * SWFTagTypes interface
     */
    public void tagGenerator( byte[] data ) throws IOException
        println( "generator tag" );
        
        if( dumpHex )
        {
            Hex.dump( writer, data, 0L, indent + "    ", false );
            println( dashes );
        }        
     * SWFTagTypes interface
     */
    public void tagGeneratorText( byte[] data ) throws IOException
        println( "generator text" );
        
        if( dumpHex )
        {
            Hex.dump( writer, data, 0L, indent + "    ", false );
            println( dashes );
        }        
    
     * SWFTagTypes interface
     */
    public void tagGeneratorFont( byte[] data ) throws IOException
        println( "generator font" );
        
        if( dumpHex )
        {
            Hex.dump( writer, data, 0L, indent + "    ", false );
            println( dashes );
        }        
    /**
     * SWFTagTypes interface
     */
    public void tagGeneratorCommand( byte[] data ) throws IOException
        println( "generator command" );
        
        if( dumpHex )
        {
            Hex.dump( writer, data, 0L, indent + "    ", false );
            println( dashes );
        }        

    /**
     * SWFTagTypes interface
     */
    public void tagNameCharacter( byte[] data ) throws IOException
        println( "generator name character" );
        
        if( dumpHex )
        {
            Hex.dump( writer, data, 0L, indent + "    ", false );
            println( dashes );
        }        
     * SWFTagTypes interface
     */
    public void tagDefineBits( int id, byte[] imageData ) throws IOException
        println( "jpeg bits" );
        
        if( dumpHex )
        {
            Hex.dump( writer, imageData, 0L, indent + "    ", false );
            println( dashes );
        }        
     * SWFTagTypes interface
     */
    public void tagJPEGTables( byte[] jpegEncodingData ) throws IOException
        println( "jpeg encoding data" );
        
        if( dumpHex )
        {
            Hex.dump( writer, jpegEncodingData, 0L, indent + "    ", false );
            println( dashes );
        }        

     * SWFTagTypes interface
     */
    public void tagDefineBitsJPEG3( int id, byte[] imageData, byte[] alphaData ) throws IOException
        println( "jpeg with alpha" );
        
        if( dumpHex )
        {
            Hex.dump( writer, imageData, 0L, indent + "    ", false );
            println( "--- Alpha Channel follows ---" );
            Hex.dump( writer, alphaData, 0L, indent + "    ", false );
            println( dashes );
        }         
    
    /**
     * SWFTagTypes interface
     */
    public void tagDefineSound( int id, int format, int frequency,
                                boolean bits16, boolean stereo,
                                int sampleCount, byte[] soundData ) throws IOException
        if( frequency == SWFConstants.SOUND_FREQ_11KHZ ) freq = "11";
        if( format == SWFConstants.SOUND_FORMAT_ADPCM ) formatS = "ADPCM";
        println( "define sound: id=" + id + " format=" + formatS + 
        
        if( dumpHex )
        {
            Hex.dump( writer, soundData, 0L, indent + "    ", false );
            println( dashes );
        }        
     * SWFTagTypes interface
     */
    public void tagDefineButtonSound( int buttonId,
        println( "define button sound: id=" + buttonId );
        println( "    roll-over sound=" + rollOverSoundId + " " + rollOverSoundInfo );
        println( "    roll-out  sound=" + rollOutSoundId  + " " + rollOutSoundInfo );
        println( "    press     sound=" + pressSoundId    + " " + pressSoundInfo );
        println( "    release   sound=" + releaseSoundId  + " " + releaseSoundInfo );       
    
    /**
     * SWFTagTypes interface
     */
    public void tagShowFrame() throws IOException
    {
        println( "---------- frame ----------" );
    /**
     * SWFTagTypes interface
     */
    public SWFActions tagDoAction() throws IOException
        println( "actions:" );
        
        ActionTextWriter acts = new ActionTextWriter( writer );
        acts.indent = "    " + indent ;
        return acts;
    }
    
     * SWFTagTypes interface
     */
    public SWFShape tagDefineShape( int id, Rect outline ) throws IOException
        println( "shape id=" + id + "   " + outline );
        return this;
    
    
     * SWFTagTypes interface
     */
    public SWFShape tagDefineShape2( int id, Rect outline ) throws IOException
        return this;
    
     * SWFTagTypes interface
     */
    public SWFShape tagDefineShape3( int id, Rect outline ) throws IOException
        println( "shape3 id=" + id + "   " + outline );
        return this;
    
    /**
     * SWFTagTypes interface
     */    
    public void tagFreeCharacter( int charId ) throws IOException 
    {
        println( "free character id=" + charId );
    }
    
    /**
     * SWFTagTypes interface
     */    
    public void tagPlaceObject( int charId, int depth, 
    {
    }
    /**
     * SWFTagTypes interface
     */    
    public SWFActions tagPlaceObject2( boolean isMove,
                                       int clipDepth,
                                       int depth,
                                       int charId,
                                       Matrix matrix,
                                       AlphaTransform cxform,
                                       int ratio,
                                       String name,
                                       int clipActionFlags )  
        throws IOException    
    {
        println( "place-object2 move=" + isMove +
                 " id=" + charId +                         
                 " ratio=" + ratio +
                 " name=" + name +
        
        if( clipActionFlags != 0 )
        {
            println( "  clip-actions:" );
            acts.indent = "    " + indent ;
            return acts;
        }
        
        return null;
    }
        
    /**
     * SWFTagTypes interface
     */ 
    {
    }
        
    /**
     * SWFTagTypes interface
     */ 
    {
    }

    /**
     * SWFTagTypes interface
     */ 
    {
        println( "background-color  " + color );        
    }

    /**
     * SWFTagTypes interface
     */ 
        println( "frame-label " + label );
    
    /**
     * SWFTagTypes interface
     */ 
    {
        println( "sprite id=" + id );
        
        SWFTagDumper dumper = new SWFTagDumper( writer, dumpHex, decompileActions );
        dumper.indent = indent + "    ";
        return dumper;
    
    /**
     * SWFTagTypes interface
     */ 
    {
    }
    /**
     * SWFTagTypes interface
     */ 
    {
        println( "enable-debug" );        
    /**
     * SWFTagTypes interface
     */ 
    {
        return this;
    /**
     * SWFTagTypes interface
     */ 
        throws IOException
    {
        println( "font-info id=" + fontId + " name=" + fontName + 
                 " flags=" + Integer.toBinaryString( flags ) + " codes=" + codes.length );
    /**
     * SWFTagTypes interface
     */ 
                                      int ascent, int descent, int leading,
                                      int[] codes, int[] advances, Rect[] bounds,
                                      int[] kernCodes1, int[] kernCodes2,
                                      int[] kernAdjustments ) throws IOException
    {
        println( "font2 id=" + id + " flags=" + Integer.toBinaryString( flags ) +
                 " name=" + name + " ascent=" + ascent + " descent=" + descent +
        
        return this;
    
    /**
     * SWFTagTypes interface
     */ 
                    String initialText, Rect boundary, int flags,
                    AlphaColor textColor, int alignment, int fontId, int fontSize, 
                    int charLimit, int leftMargin, int rightMargin, int indentation,
                    int lineSpacing ) 
        throws IOException
    {
        println( "edit-field id=" + fieldId + " name=" + fieldName +
                 " flags=" + Integer.toBinaryString( flags ) +
    }

    /**
     * SWFTagTypes interface
     */ 
        throws IOException
    { 
        println( "text id=" + id + " " + bounds + " " + matrix );
        return this;
     * SWFTagTypes interface
     */ 
    { 
        println( "text2 id=" + id + " " + bounds + " " + matrix );
        return this;
    /**
     * SWFTagTypes interface
     */ 
        throws IOException
    {
        println( "button id=" + id );
        
        for( Enumeration enum = buttonRecords.elements(); enum.hasMoreElements(); )
        {
        }

        acts.indent = "    " + indent ;
        return acts;
    }
    
    /**
     * SWFTagTypes interface
     */ 
        throws IOException
    {
        println( "button-cxform id=" + buttonId + "  " + transform );
    /**
     * SWFTagTypes interface
     */ 
        throws IOException
    {
        
        for( Enumeration enum = buttonRecord2s.elements(); enum.hasMoreElements(); )
        {
        }

        acts.indent = "    " + indent ;
        return acts;
            
    }
    /**
     * SWFTagTypes interface
     */ 
    {
        println( "export" );
        
        for( int i = 0; i < names.length && i < ids.length; i++ )
        {
            println( "  id=" + ids[i] + " name=" + names[i] );
        }
    }
    
    /**
     * SWFTagTypes interface
     */ 
        throws IOException
    {
        println( "import library-movie=" + movieName );
        
        for( int i = 0; i < names.length && i < ids.length; i++ )
        {
            println( "  id=" + ids[i] + " name=" + names[i] );
        }
    }
    
    /**
     * SWFTagTypes interface
     */ 
    {
    }
    /**
     * SWFTagTypes interface
     */ 
    {
        println( "jpeg2 id=" + id );

        if( dumpHex )
        {
            Hex.dump( writer, data, 0L, indent + "    ", false );
            println( dashes );
        }
    }
     * SWFTagTypes interface
     */ 
    {
        println( "jpeg2 id=" + id + " (from input stream)" );        
    
     * SWFTagTypes interface
     */ 
    {
        println( "morph-shape id=" + id + " start: " + 
                 startBounds + "  end: " + endBounds );
        return this;
    
    /**
     * SWFTagTypes interface
     */ 
    {
    
     * SWFTagTypes interface
     */ 
    public void tagDefineBitsLossless2( int id, int format, int width, int height,
    {
        dumpBitsLossless( "bits-lossless2", id, format, width, height, colors, imageData );
    
    public void dumpBitsLossless( String name, int id, int format, 
                                  int width, int height,
    {
        int size = 0;
        if     ( format == SWFConstants.BITMAP_FORMAT_8_BIT  ) size = 8;
        else if( format == SWFConstants.BITMAP_FORMAT_16_BIT ) size = 16;
        else if( format == SWFConstants.BITMAP_FORMAT_32_BIT ) size = 32;
        
        println( name + " id=" + id + " bits=" + size + 
                 " width=" + width + " height=" + height );
        
        if( dumpHex )
        {
            for( int i = 0; i < colors.length; i++ )
            {
                println( "    " + i + ": " + colors[i] );
            }
            
            Hex.dump( writer, imageData, 0L, indent + "    ", false );
            println( dashes );
        }
    }
    
    /**
     * SWFVectors interface
     * SWFText interface
     */     
    public void done() throws IOException
    {
        println( "    " + dashes );
    }
    
    /**
     * SWFVectors interface
     */     
    public void line( int dx, int dy ) throws IOException
    {
        println( "    line  " + dx + "," + dy );        
    }
    
    /**
     * SWFVectors interface
     */     
    public void curve( int cx, int cy, int dx, int dy ) throws IOException
    {
        println( "    curve " + cx + "," + cy + " - " + dx + "," + dy );                
    }
    
    /**
     * SWFVectors interface
     */     
    public void move( int x, int y ) throws IOException
    {
        println( "    move  " + x + "," + y );        
    }
    
    /**
     * SWFShape interface
     */     
    public void setFillStyle0( int styleIndex ) throws IOException
    {
        println( "    fill0 = " + styleIndex );
    }
    
    /**
     * SWFShape interface
     */     
    public void setFillStyle1( int styleIndex ) throws IOException
    {
        println( "    fill1 = " + styleIndex );
    }    
    
    /**
     * SWFShape interface
     */     
    public void setLineStyle( int styleIndex ) throws IOException
    {
        println( "    line  = " + styleIndex );
    }    

    /**
     * SWFShape interface
     */     
    public void defineFillStyle( Color color ) throws IOException
    {
        println( "    fill " + color );
    }    

    /**
     * SWFShape interface
     */     
    public void defineFillStyle( Matrix matrix, int[] ratios,
                                 Color[] colors, boolean radial )
        throws IOException
    {
        println( "    fill radial=" + radial + "  " + matrix );
        
        for( int i = 0; i < ratios.length && i < colors.length; i++ )
        {
            if( colors[i] == null ) continue;
            println( "         ratio=" + ratios[i] + " " + colors[i] );
        }
    }    

    /**
     * SWFShape interface
     */     
    public void defineFillStyle( int bitmapId, Matrix matrix, boolean clipped )
        throws IOException
    {
        println( "    fill clipped=" + clipped + " image=" + bitmapId + " " + matrix );
    }
    
    /**
     * SWFShape interface
     */     
    public void defineLineStyle( int width, Color color ) throws IOException
    {
        println( "    line-style width=" + width + "  " + color );
    }
    
    /**
     * SWFText interface
     */     
    public void font( int fontId, int textHeight ) throws IOException
    {
        println( "    font id=" + fontId + " size=" + textHeight );
    }
    
    /**
     * SWFText interface
     */     
    public void color( Color color ) throws IOException
    {
        println( "    color " + color );
    }
    
    /**
     * SWFText interface
     */     
    public void setX( int x ) throws IOException
    {
        println( "    x = " + x );
    }

    /**
     * SWFText interface
     */     
    public void setY( int y ) throws IOException
    {
        println( "    y = " + y );
    }
    
    /**
     * SWFText interface
     */     
    public void text( int[] glyphIndices, int[] glyphAdvances ) throws IOException
    {
        StringBuffer buff1 = new StringBuffer();
        StringBuffer buff2 = new StringBuffer();
        
        buff1.append( "(" );
        buff2.append( "(" );
        
        for( int i = 0; i < glyphIndices.length && i < glyphAdvances.length; i++ )
        {
            buff1.append( " " );
            buff2.append( " " );
            
            buff1.append( glyphIndices[i] );
            buff2.append( glyphAdvances[i] );
        }
        
        buff1.append( " )" );
        buff2.append( " )" );

        println( "    text" );
        println( "        glyph indices = " + buff1 );
        println( "        advances      = " + buff2 );
    }
    
    public void flush() throws IOException
    {
        writer.flush();
    }
    
    /**
     * args[0] = name of SWF file to dump to System.out
     * args[1] = if exists then dump-hex is true (dumps binary as hex - otherwise skips)
     * args[2] = if exists then decompiles action codes
     */
    public static void main( String[] args ) throws IOException
    {
        SWFTagDumper dumper = new SWFTagDumper( args.length > 1, args.length > 2 );
        
        FileInputStream in  = new FileInputStream( args[0] );
        SWFTags tagparser = new TagParser( dumper );
        SWFReader reader = new SWFReader( tagparser, in );
        
        try
        {
            reader.readFile();
        }
        finally
        {        
            dumper.flush();
            in.close();
        }        
    }
}