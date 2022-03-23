package org.nrnb.gsoc.enrichment.constants;

/**
 * Class containing regular HTTP response status code
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#successful_responses">
 *     Status codes</a>
 * @author akmo3
 */
public final class HTTP_RESPONSE_CODES {

    /**
     * Response indicates that the client should continue the request or
     * ignore the response if the request is already finished.
     */
    public static final short CONTINUE = 100;

    public static final short PROCESSING = 102;

    /**
     * Response to the request made by the client is accepted and successful.
     */
    public static final short OK = 200;

    /**
     * Request succeeded and a new resource was created successfully.
     */
    public static final short CREATED = 201;

    /**
     * The request has been received but not yet acted upon.
     */
    public static final short ACCEPTED = 202;

    /**
     * No content associated with this request.
     */
    public static final short NO_CONTENT = 204;
}
