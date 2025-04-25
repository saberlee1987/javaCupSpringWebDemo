package ir.javacup.demo.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import ir.javacup.demo.domain.api.*;
import ir.javacup.demo.services.PersonFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${service.baseUrl}/person", produces = "application/json")
@Tag(name = "person crud operation")
@RequiredArgsConstructor
public class PersonRestController {

    private final PersonFacade personFacade;

    @Operation(summary = "save person", description = "save person", method = "POST"
            , requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    examples = @ExampleObject(value = """
                            {
                               "firstName": "saber",
                              "lastName": "azizi",
                              "nationalCode": "0079028748",
                              "age": 37,
                              "mobile": "09365627895",
                              "email": "saberazizi66@yahoo.com"
                            }
                            """)
            ))
            , responses = {
            @ApiResponse(description = "success", responseCode = "200"
                    , content = @Content(schema = @Schema(implementation = PersonSaveResponse.class)))

            , @ApiResponse(description = "BAD_REQUEST", responseCode = "400"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "NOT_ACCEPTABLE", responseCode = "406"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "INTERNAL_SERVER_ERROR", responseCode = "500"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "NOT_IMPLEMENTED", responseCode = "501"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "BAD_GATEWAY", responseCode = "502"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "SERVICE_UNAVAILABLE", responseCode = "503"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    }
    )
    @PostMapping
    public PersonSaveResponse savePerson(@RequestBody @Valid PersonSaveRequest request) {
        return personFacade.savePerson(request);
    }

    @Operation(summary = "update person", description = "update person", method = "PUT"
            , requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    examples = @ExampleObject(value = """
                            {
                              "personId" : 1,
                               "firstName": "saber",
                              "lastName": "azizi",
                              "nationalCode": "0079028748",
                              "age": 37,
                              "mobile": "09365627895",
                              "email": "saberazizi66@yahoo.com"
                            }
                            """)
            ))
            , responses = {
            @ApiResponse(description = "success", responseCode = "200"
                    , content = @Content(schema = @Schema(implementation = PersonDto.class)))

            , @ApiResponse(description = "BAD_REQUEST", responseCode = "400"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "NOT_ACCEPTABLE", responseCode = "406"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "INTERNAL_SERVER_ERROR", responseCode = "500"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "NOT_IMPLEMENTED", responseCode = "501"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "BAD_GATEWAY", responseCode = "502"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "SERVICE_UNAVAILABLE", responseCode = "503"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    }
    )
    @PutMapping
    public PersonDto updatePerson(@RequestBody @Valid PersonSaveRequest request) {
        return personFacade.updatePerson(request);
    }


    @GetMapping(value = "/{personId}")
    @Operation(summary = "find person personId", description = "find person personId", method = "GET"
            , parameters = {
            @Parameter(name = "personId", in = ParameterIn.PATH, example = "1")
    }
            , responses = {
            @ApiResponse(description = "success", responseCode = "200"
                    , content = @Content(schema = @Schema(implementation = PersonDto.class)))

            , @ApiResponse(description = "BAD_REQUEST", responseCode = "400"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "NOT_ACCEPTABLE", responseCode = "406"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "INTERNAL_SERVER_ERROR", responseCode = "500"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "NOT_IMPLEMENTED", responseCode = "501"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "BAD_GATEWAY", responseCode = "502"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "SERVICE_UNAVAILABLE", responseCode = "503"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    }
    )
    public PersonDto getPersonById(@PathVariable Long personId) {
        return personFacade.getPersonById(personId);
    }

    @DeleteMapping(value = "/{personId}")
    @Operation(summary = "delete person personId", description = "delete person personId", method = "DELETE"
            , parameters = {
            @Parameter(name = "personId", in = ParameterIn.PATH, example = "1")
    }
            , responses = {
            @ApiResponse(description = "success", responseCode = "200"
                    , content = @Content(schema = @Schema(implementation = PersonDeleteResponse.class)))

            , @ApiResponse(description = "BAD_REQUEST", responseCode = "400"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "NOT_ACCEPTABLE", responseCode = "406"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "INTERNAL_SERVER_ERROR", responseCode = "500"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "NOT_IMPLEMENTED", responseCode = "501"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "BAD_GATEWAY", responseCode = "502"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "SERVICE_UNAVAILABLE", responseCode = "503"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    }
    )
    public PersonDeleteResponse deletePersonById(@PathVariable Long personId) {
        return personFacade.deletePersonById(personId);
    }

    @GetMapping(value = "/findAll")
    @Operation(summary = "findAll person", description = "findAll person", method = "GET"
            , responses = {
            @ApiResponse(description = "success", responseCode = "200"
                    , content = @Content(schema = @Schema(implementation = PersonResponseList.class)))

            , @ApiResponse(description = "BAD_REQUEST", responseCode = "400"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "NOT_ACCEPTABLE", responseCode = "406"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "INTERNAL_SERVER_ERROR", responseCode = "500"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "NOT_IMPLEMENTED", responseCode = "501"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "BAD_GATEWAY", responseCode = "502"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))

            , @ApiResponse(description = "SERVICE_UNAVAILABLE", responseCode = "503"
            , content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    }
    )
    public PersonResponseList getAllPersonList() {
        return personFacade.getAllPersons();
    }

}
