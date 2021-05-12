<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:office="urn:oasis:names:tc:opendocument:xmlns:office:1.0"
    xmlns:text="urn:oasis:names:tc:opendocument:xmlns:text:1.0"
    xmlns:table="urn:oasis:names:tc:opendocument:xmlns:table:1.0"
    xmlns:tools="http://www.insee.fr/tools" office:version="1.2"
    office:mimetype="application/vnd.oasis.opendocument.spreadsheet"
    exclude-result-prefixes="tools xs office text table " version="2.0">

    <xsl:import href="./utils.xsl"/>
    <xsl:output indent="yes"/>

    <xsl:variable name="usersSheet" select="//office:spreadsheet/table:table[@table:name = 'users']"/>

    <xsl:function name="tools:get-users">
        <xsl:param name="organisationUnit"/>
        <xsl:variable name="sheet" select="$usersSheet"/>
        <xsl:copy-of
            select="$sheet/table:table-row[normalize-space(table:table-cell[1]) = $organisationUnit]"
        />
    </xsl:function>

    <xsl:template match="/">
        <Context>
            <xsl:apply-templates
                select="//office:spreadsheet/table:table[@table:name = 'organisationUnits']"/>
        </Context>
    </xsl:template>

    <xsl:template
        match="office:body/office:spreadsheet/table:table[@table:name = 'organisationUnits']">
        <OrganisationUnits>
            <xsl:for-each select="table:table-row[position() > 1]">
                <xsl:variable name="row" select="tools:get-full-row(.)"/>
                <xsl:if test="normalize-space($row) != ''">
                    <OrganisationUnit>
                        <OrganisationUnit>
                            <xsl:value-of select="tools:getColumn($row, 1)"/>
                        </OrganisationUnit>
                        <OrganisationUnitLabel>
                            <xsl:value-of select="tools:getColumn($row, 2)"/>
                        </OrganisationUnitLabel>
                        <Type>
                            <xsl:value-of select="tools:getColumn($row, 3)"/>
                        </Type>
                        <OrganisationUnitRefs>
                            <xsl:for-each select="tokenize(tools:getColumn($row,4),',')">
                                <OrganisationUnitRef><xsl:value-of select="."/></OrganisationUnitRef>
                            </xsl:for-each>
                        </OrganisationUnitRefs>
                        <Users>
                            <xsl:for-each select="tools:get-users(tools:getColumn($row, 1))">
                                <xsl:variable name="userRow" select="tools:get-full-row(.)"/>
                                <User>
                                    <Id>
                                        <xsl:value-of select="tools:getColumn($userRow, 2)"/>
                                    </Id>
                                    <FirstName>
                                        <xsl:value-of select="tools:getColumn($userRow, 3)"/>
                                    </FirstName>
                                    <LastName>
                                        <xsl:value-of select="tools:getColumn($userRow, 4)"/>
                                    </LastName>
                                </User>
                            </xsl:for-each>
                        </Users>
                    </OrganisationUnit>
                </xsl:if>
            </xsl:for-each>
        </OrganisationUnits>
    </xsl:template>
</xsl:stylesheet>
