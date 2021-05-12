<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" 
    xmlns:fn="http://www.w3.org/2005/xpath-functions" 
    xmlns:xd="http://www.oxygenxml.com/ns/doc/xsl"
    xmlns:eno="http://xml.insee.fr/apps/eno" 
    xmlns:enojs="http://xml.insee.fr/apps/eno/out/js"
    xmlns:h="http://xml.insee.fr/schema/applis/lunatic-h"
    xmlns:foo="http://whatever"
    xmlns:math="http://www.w3.org/2005/xpath-functions/math"
    xmlns="http://xml.insee.fr/schema/applis/lunatic-h"
    exclude-result-prefixes="xs fn xd eno enojs h" version="2.0">
    
    <xsl:output indent="yes"/>
    
    <xsl:param name="number-of-repetitions" select="1"/>
    
    <xsl:template match="/" >
        <xsl:apply-templates/>
    </xsl:template>
    
    <xsl:template match="Questionnaires">
        <xsl:copy>
            <xsl:copy-of select="@*"/>
            <xsl:call-template name="repeat">
                <xsl:with-param name="Questionnaire" select="./Questionnaire"/>
                <xsl:with-param name="N" select="$number-of-repetitions"/>
            </xsl:call-template>
        </xsl:copy>
    </xsl:template>
    
    <xsl:template name="repeat">
        <xsl:param name="Questionnaire"/>
        <xsl:param name="N"/>
        <xsl:if test="$N > 0">
            <xsl:apply-templates select="Questionnaire" mode="repetition">
                <xsl:with-param name="occurence" select="$number-of-repetitions - $N + 1" tunnel="yes"/>
            </xsl:apply-templates>
            <xsl:call-template name="repeat">
                <xsl:with-param name="Questionnaire" select="Questionnaire"/>
                <xsl:with-param name="N" select="$N - 1"/>
            </xsl:call-template>
        </xsl:if>       
    </xsl:template>
    
    <xsl:template match="Variable[@idVariable='QuiRepond1']/Valeur" mode="repetition">
        <xsl:param name="occurence" tunnel="yes"/>
        <xsl:copy><xsl:value-of select="concat('TMC2020U',foo:compute-id($occurence))"/></xsl:copy>
    </xsl:template>
    
    <xsl:template match="Identifiant" mode="repetition">
        <xsl:param name="occurence" tunnel="yes"/>
        <xsl:copy><xsl:value-of select="concat('TMC2020U',foo:compute-id($occurence))"/></xsl:copy>
    </xsl:template>
    
    <xsl:template match="@*|node()" mode="repetition">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()" mode="repetition"/>
        </xsl:copy>
    </xsl:template>
    
    <xsl:template match="@*|node()">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()"/>
        </xsl:copy>
    </xsl:template>
    
    <xsl:function name="foo:compute-id">
        <xsl:param name="current-occurence"/>
        <xsl:variable name="nbZeros" select="(floor(math:log10($number-of-repetitions))+1) - (floor(math:log10($current-occurence))+1)"/>
        <xsl:call-template name="foo:compute-id-template">
            <xsl:with-param name="current-occurence" select="$current-occurence"/>
            <xsl:with-param name="nbZeros" select="$nbZeros"/>
        </xsl:call-template>
    </xsl:function>
        
    <xsl:template name="foo:compute-id-template">
        <xsl:param name="current-occurence"/>
        <xsl:param name="nbZeros"/>
        <xsl:choose>
            <xsl:when test="$nbZeros &gt; 0">
                <xsl:call-template name="foo:compute-id-template">
                    <xsl:with-param name="current-occurence" select="concat('0',$current-occurence)"/>
                    <xsl:with-param name="nbZeros" select="$nbZeros - 1"/>
                </xsl:call-template>
            </xsl:when>
            <xsl:otherwise><xsl:value-of select="$current-occurence"/></xsl:otherwise>
        </xsl:choose>
    </xsl:template>
    
</xsl:stylesheet>