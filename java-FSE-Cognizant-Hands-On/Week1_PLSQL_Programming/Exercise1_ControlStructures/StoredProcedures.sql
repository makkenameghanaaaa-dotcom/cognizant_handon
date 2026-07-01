CREATE OR REPLACE PROCEDURE ShowMessage
AS
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello from Stored Procedure');
END;
/

BEGIN
    ShowMessage;
END;
/