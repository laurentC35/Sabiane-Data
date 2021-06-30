<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:office="urn:oasis:names:tc:opendocument:xmlns:office:1.0"
    xmlns:text="urn:oasis:names:tc:opendocument:xmlns:text:1.0"
    xmlns:table="urn:oasis:names:tc:opendocument:xmlns:table:1.0"
    xmlns:tools="http://www.insee.fr/tools"
    office:version="1.2" office:mimetype="application/vnd.oasis.opendocument.spreadsheet"
    exclude-result-prefixes="tools xs office text table "
    version="2.0">
    
    <xsl:import href="./utils.xsl"/>
    <xsl:output indent="yes"/>
    
    <xsl:param name="folder"/>
    <xsl:param name="questionnaire" as="node()" required="yes"/>
    
    <xsl:template match="/">
        <Campaign>
            <xsl:apply-templates select="//office:spreadsheet/table:table[@table:name='operation']"/>
            <xsl:apply-templates select="//office:spreadsheet/table:table[@table:name='questionnaireModel']"/>
            <xsl:apply-templates select="//office:spreadsheet/table:table[@table:name='surveyUnits']"/>
        </Campaign>
    </xsl:template>
    
    
    <xsl:template match="office:body/office:spreadsheet/table:table[@table:name='operation']">
        <xsl:variable name="row" select="tools:get-full-row(table:table-row[2])"/>
        <Id><xsl:value-of select="upper-case(tools:getColumn($row,1))"/></Id>
        <Label><xsl:value-of select="tools:getColumn($row,2)"/></Label>
    </xsl:template>
    
    <xsl:template match="office:body/office:spreadsheet/table:table[@table:name='questionnaireModel']">        
        <xsl:variable name="row" select="tools:get-full-row(table:table-row[2])"/>
        <QuestionnaireModel>
            <Id><xsl:value-of select="upper-case(tools:getColumn($row,1))"/></Id>
            <Label><xsl:value-of select="tools:getColumn($row,2)"/></Label>
            <xsl:copy-of select="$questionnaire"/>
            <RequiredNomenclatures>
                <xsl:for-each select="tokenize(tools:getColumn($row,3),',')">
                    <NomenclatureId><xsl:value-of select="."/></NomenclatureId>
                </xsl:for-each>
            </RequiredNomenclatures>
        </QuestionnaireModel>
    </xsl:template>
    
    <xsl:template match="office:body/office:spreadsheet/table:table[@table:name='surveyUnits']">
        <SurveyUnits>
            <xsl:for-each select="table:table-row[position()>1]">
                <xsl:variable name="row" select="tools:get-full-row(.)"/>
                <xsl:if test="normalize-space($row)!=''">
                    <SurveyUnit>
                        <Id><xsl:value-of select="tools:getColumn($row,1)"/></Id>
                        <xsl:copy-of select="document(concat($folder,'/',replace(tools:getColumn($row,2),'.json','.xml')))"/>
                    </SurveyUnit>
                </xsl:if>
            </xsl:for-each>
        </SurveyUnits>
    </xsl:template>
</xsl:stylesheet>