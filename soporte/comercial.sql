--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.6
-- Dumped by pg_dump version 9.5.6

-- Started on 2017-04-25 00:26:22 CLST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12487)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2594 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 24698)
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE category (
    id_category integer NOT NULL,
    denomination character varying(100) NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone,
    status smallint NOT NULL
);


ALTER TABLE category OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 24701)
-- Name: category_idCategory_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "category_idCategory_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "category_idCategory_seq" OWNER TO postgres;

--
-- TOC entry 2595 (class 0 OID 0)
-- Dependencies: 187
-- Name: category_idCategory_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "category_idCategory_seq" OWNED BY category.id_category;


--
-- TOC entry 188 (class 1259 OID 24703)
-- Name: color; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE color (
    id_color integer NOT NULL,
    denomination character varying(60) NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone,
    status smallint NOT NULL,
    hex character varying,
    class character varying,
    d character varying,
    class_m character varying
);


ALTER TABLE color OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 24709)
-- Name: color_idColor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "color_idColor_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "color_idColor_seq" OWNER TO postgres;

--
-- TOC entry 2596 (class 0 OID 0)
-- Dependencies: 189
-- Name: color_idColor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "color_idColor_seq" OWNED BY color.id_color;


--
-- TOC entry 190 (class 1259 OID 24711)
-- Name: country; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE country (
    id_country integer NOT NULL,
    country_code character varying(2),
    name character varying(80)
);


ALTER TABLE country OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 24714)
-- Name: country_id_country_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE country_id_country_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE country_id_country_seq OWNER TO postgres;

--
-- TOC entry 2597 (class 0 OID 0)
-- Dependencies: 191
-- Name: country_id_country_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE country_id_country_seq OWNED BY country.id_country;


--
-- TOC entry 192 (class 1259 OID 24716)
-- Name: discount; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE discount (
    id_discount integer NOT NULL,
    code character varying(100) NOT NULL,
    description character varying(500) NOT NULL,
    date_init timestamp(0) without time zone NOT NULL,
    date_end timestamp(0) without time zone NOT NULL,
    id_calcu_base smallint NOT NULL,
    aliquot double precision NOT NULL,
    status smallint NOT NULL,
    use_limit smallint NOT NULL,
    type_user smallint NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone
);


ALTER TABLE discount OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 24722)
-- Name: discount_idDiscount_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "discount_idDiscount_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "discount_idDiscount_seq" OWNER TO postgres;

--
-- TOC entry 2598 (class 0 OID 0)
-- Dependencies: 193
-- Name: discount_idDiscount_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "discount_idDiscount_seq" OWNED BY discount.id_discount;


--
-- TOC entry 194 (class 1259 OID 24724)
-- Name: discount_purchase; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE discount_purchase (
    id_discount_purchase integer NOT NULL,
    id_discount bigint NOT NULL,
    id_purchase bigint NOT NULL,
    discount numeric,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone
);


ALTER TABLE discount_purchase OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 24730)
-- Name: discount_purchase_id_discount_purchase_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE discount_purchase_id_discount_purchase_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE discount_purchase_id_discount_purchase_seq OWNER TO postgres;

--
-- TOC entry 2599 (class 0 OID 0)
-- Dependencies: 195
-- Name: discount_purchase_id_discount_purchase_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE discount_purchase_id_discount_purchase_seq OWNED BY discount_purchase.id_discount_purchase;


--
-- TOC entry 196 (class 1259 OID 24732)
-- Name: discount_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE discount_user (
    id_discount_user integer NOT NULL,
    id_discount bigint NOT NULL,
    id_user bigint NOT NULL,
    status smallint NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone
);


ALTER TABLE discount_user OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 24735)
-- Name: discount_user_idDiscountUser_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "discount_user_idDiscountUser_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "discount_user_idDiscountUser_seq" OWNER TO postgres;

--
-- TOC entry 2600 (class 0 OID 0)
-- Dependencies: 197
-- Name: discount_user_idDiscountUser_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "discount_user_idDiscountUser_seq" OWNED BY discount_user.id_discount_user;


--
-- TOC entry 198 (class 1259 OID 24737)
-- Name: district; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE district (
    id_district integer NOT NULL,
    denomination character varying(60) NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone
);


ALTER TABLE district OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 24740)
-- Name: district_id_district_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE district_id_district_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE district_id_district_seq OWNER TO postgres;

--
-- TOC entry 2601 (class 0 OID 0)
-- Dependencies: 199
-- Name: district_id_district_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE district_id_district_seq OWNED BY district.id_district;


--
-- TOC entry 200 (class 1259 OID 24742)
-- Name: enviroment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE enviroment (
    id_enviroment integer NOT NULL,
    denomination character varying(100) NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone,
    status smallint NOT NULL,
    id_image integer
);


ALTER TABLE enviroment OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 24745)
-- Name: enviroment_id_enviroment_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE enviroment_id_enviroment_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE enviroment_id_enviroment_seq OWNER TO postgres;

--
-- TOC entry 2602 (class 0 OID 0)
-- Dependencies: 201
-- Name: enviroment_id_enviroment_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE enviroment_id_enviroment_seq OWNED BY enviroment.id_enviroment;


--
-- TOC entry 181 (class 1259 OID 24641)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hibernate_sequence OWNER TO root;

--
-- TOC entry 237 (class 1259 OID 25157)
-- Name: id_product_offer_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE id_product_offer_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 99999
    CACHE 1;


ALTER TABLE id_product_offer_seq OWNER TO postgres;

--
-- TOC entry 235 (class 1259 OID 25032)
-- Name: id_product_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE id_product_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 99999
    CACHE 1;


ALTER TABLE id_product_seq OWNER TO postgres;

--
-- TOC entry 236 (class 1259 OID 25067)
-- Name: id_relationated_product_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE id_relationated_product_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 99999
    CACHE 1;


ALTER TABLE id_relationated_product_seq OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 24747)
-- Name: image; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE image (
    id_image integer NOT NULL,
    imagefile character varying(70) NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone
);


ALTER TABLE image OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 24750)
-- Name: image_idimage_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE image_idimage_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE image_idimage_seq OWNER TO postgres;

--
-- TOC entry 2603 (class 0 OID 0)
-- Dependencies: 203
-- Name: image_idimage_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE image_idimage_seq OWNED BY image.id_image;


--
-- TOC entry 204 (class 1259 OID 24752)
-- Name: ipn; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE ipn (
    id_ipn integer NOT NULL,
    valor character varying(600) NOT NULL,
    fecha timestamp without time zone
);


ALTER TABLE ipn OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 24758)
-- Name: ipn_id_ipn_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ipn_id_ipn_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ipn_id_ipn_seq OWNER TO postgres;

--
-- TOC entry 2604 (class 0 OID 0)
-- Dependencies: 205
-- Name: ipn_id_ipn_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ipn_id_ipn_seq OWNED BY ipn.id_ipn;


--
-- TOC entry 206 (class 1259 OID 24760)
-- Name: migrations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE migrations (
    migration character varying(255) NOT NULL,
    batch integer NOT NULL
);


ALTER TABLE migrations OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 24763)
-- Name: offer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE offer (
    id_offer integer NOT NULL,
    denomination character varying(100) NOT NULL,
    description character varying(500) NOT NULL,
    date_init timestamp(0) without time zone NOT NULL,
    date_end timestamp(0) without time zone NOT NULL,
    id_calcu_base smallint NOT NULL,
    aliquot double precision NOT NULL,
    status smallint NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone
);


ALTER TABLE offer OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 24769)
-- Name: offer_idOffer_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "offer_idOffer_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "offer_idOffer_seq" OWNER TO postgres;

--
-- TOC entry 2605 (class 0 OID 0)
-- Dependencies: 208
-- Name: offer_idOffer_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "offer_idOffer_seq" OWNED BY offer.id_offer;


--
-- TOC entry 209 (class 1259 OID 24771)
-- Name: order; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "order" (
    id_order integer NOT NULL,
    date timestamp(0) without time zone,
    id_user integer NOT NULL,
    status integer NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone,
    discount numeric,
    id_ship_info integer
);


ALTER TABLE "order" OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 24777)
-- Name: order_detail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE order_detail (
    id_order_detail integer NOT NULL,
    id_order integer NOT NULL,
    status integer NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone,
    id_product integer NOT NULL,
    quantity integer NOT NULL,
    price double precision NOT NULL
);


ALTER TABLE order_detail OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 24780)
-- Name: order_detail_id_order_detail_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE order_detail_id_order_detail_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE order_detail_id_order_detail_seq OWNER TO postgres;

--
-- TOC entry 2606 (class 0 OID 0)
-- Dependencies: 211
-- Name: order_detail_id_order_detail_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE order_detail_id_order_detail_seq OWNED BY order_detail.id_order_detail;


--
-- TOC entry 212 (class 1259 OID 24782)
-- Name: order_id_order_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE order_id_order_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE order_id_order_seq OWNER TO postgres;

--
-- TOC entry 2607 (class 0 OID 0)
-- Dependencies: 212
-- Name: order_id_order_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE order_id_order_seq OWNED BY "order".id_order;


--
-- TOC entry 213 (class 1259 OID 24784)
-- Name: palette; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE palette (
    id_palette integer NOT NULL,
    denomination character varying(100) NOT NULL,
    status smallint NOT NULL
);


ALTER TABLE palette OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 24787)
-- Name: palette_id_palette_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE palette_id_palette_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE palette_id_palette_seq OWNER TO postgres;

--
-- TOC entry 2608 (class 0 OID 0)
-- Dependencies: 214
-- Name: palette_id_palette_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE palette_id_palette_seq OWNED BY palette.id_palette;


--
-- TOC entry 215 (class 1259 OID 24789)
-- Name: password_resets; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE password_resets (
    email character varying(255) NOT NULL,
    token character varying(255) NOT NULL,
    created_at timestamp(0) without time zone NOT NULL
);


ALTER TABLE password_resets OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 24795)
-- Name: payment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE payment (
    id_payment integer NOT NULL,
    id_order integer NOT NULL,
    collection_id character varying(50) NOT NULL,
    date timestamp(0) without time zone,
    transaction_amount double precision NOT NULL,
    total_paid_amount double precision NOT NULL,
    shipping_cost double precision NOT NULL,
    currency_id character varying(10),
    status character varying(30) NOT NULL,
    status_detail character varying(30) NOT NULL,
    operation_type character varying(30) NOT NULL,
    date_approved timestamp(0) without time zone,
    date_created timestamp(0) without time zone,
    last_modified timestamp(0) without time zone,
    amount_refunded double precision NOT NULL,
    preference_id character varying(60) NOT NULL,
    external_reference character varying(60) NOT NULL,
    payment_type character varying(40),
    merchant_order_id character varying(40) NOT NULL
);


ALTER TABLE payment OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 24798)
-- Name: payment_id_payment_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE payment_id_payment_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE payment_id_payment_seq OWNER TO postgres;

--
-- TOC entry 2609 (class 0 OID 0)
-- Dependencies: 217
-- Name: payment_id_payment_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE payment_id_payment_seq OWNED BY payment.id_payment;


--
-- TOC entry 218 (class 1259 OID 24800)
-- Name: product_discount; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE product_discount (
    id_product_discount integer NOT NULL,
    id_product bigint NOT NULL,
    id_discount bigint NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone
);


ALTER TABLE product_discount OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 24803)
-- Name: product_discount_id_product_discount_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE product_discount_id_product_discount_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE product_discount_id_product_discount_seq OWNER TO postgres;

--
-- TOC entry 2610 (class 0 OID 0)
-- Dependencies: 219
-- Name: product_discount_id_product_discount_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE product_discount_id_product_discount_seq OWNED BY product_discount.id_product_discount;


--
-- TOC entry 220 (class 1259 OID 24805)
-- Name: product_offer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE product_offer (
    id_offer bigint NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone,
    id_product_offer integer DEFAULT nextval('id_product_offer_seq'::regclass) NOT NULL,
    id_product integer
);


ALTER TABLE product_offer OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 24810)
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE products (
    name character varying(100) NOT NULL,
    description character varying(500) NOT NULL,
    code character varying(50) NOT NULL,
    id_color integer NOT NULL,
    price double precision NOT NULL,
    stock double precision NOT NULL,
    measure double precision NOT NULL,
    id_category bigint NOT NULL,
    id_image bigint,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone,
    material character varying NOT NULL,
    finish character varying NOT NULL,
    size character varying NOT NULL,
    item_box integer NOT NULL,
    kg_meter double precision NOT NULL,
    id_enviroment integer NOT NULL,
    price_sample double precision NOT NULL,
    palette character varying,
    rank character varying,
    id_purpose integer,
    id_product integer DEFAULT nextval('id_product_seq'::regclass) NOT NULL,
    id_status smallint
);


ALTER TABLE products OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 24818)
-- Name: purchase; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE purchase (
    id_purchase integer NOT NULL,
    id_order integer NOT NULL,
    id_payment integer NOT NULL,
    id_ship_info integer NOT NULL,
    date timestamp(0) without time zone,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone,
    status smallint
);


ALTER TABLE purchase OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 24821)
-- Name: purchase_id_purchase_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE purchase_id_purchase_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE purchase_id_purchase_seq OWNER TO postgres;

--
-- TOC entry 2611 (class 0 OID 0)
-- Dependencies: 223
-- Name: purchase_id_purchase_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE purchase_id_purchase_seq OWNED BY purchase.id_purchase;


--
-- TOC entry 224 (class 1259 OID 24823)
-- Name: purpose; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE purpose (
    id_purpose integer NOT NULL,
    denomination character varying(100) NOT NULL,
    status smallint NOT NULL
);


ALTER TABLE purpose OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 24826)
-- Name: purpose_id_purpose_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE purpose_id_purpose_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE purpose_id_purpose_seq OWNER TO postgres;

--
-- TOC entry 2612 (class 0 OID 0)
-- Dependencies: 225
-- Name: purpose_id_purpose_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE purpose_id_purpose_seq OWNED BY purpose.id_purpose;


--
-- TOC entry 226 (class 1259 OID 24828)
-- Name: rank; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE rank (
    id_rank integer NOT NULL,
    denomination character varying(100) NOT NULL,
    status smallint NOT NULL
);


ALTER TABLE rank OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 24831)
-- Name: rank_id_rank_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE rank_id_rank_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE rank_id_rank_seq OWNER TO postgres;

--
-- TOC entry 2613 (class 0 OID 0)
-- Dependencies: 227
-- Name: rank_id_rank_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE rank_id_rank_seq OWNED BY rank.id_rank;


--
-- TOC entry 228 (class 1259 OID 24833)
-- Name: relationated_product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE relationated_product (
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone,
    id_relationated_product integer DEFAULT nextval('id_relationated_product_seq'::regclass) NOT NULL,
    id_product integer,
    id_product_relation integer
);


ALTER TABLE relationated_product OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 24838)
-- Name: ship_info; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE ship_info (
    id_ship_info integer NOT NULL,
    date timestamp(0) without time zone,
    id_user integer NOT NULL,
    city character varying(90) NOT NULL,
    address character varying(400) NOT NULL,
    postal_code character varying(15),
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone,
    id_country integer,
    id_district integer
);


ALTER TABLE ship_info OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 24844)
-- Name: ship_info_id_ship_info_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ship_info_id_ship_info_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ship_info_id_ship_info_seq OWNER TO postgres;

--
-- TOC entry 2614 (class 0 OID 0)
-- Dependencies: 230
-- Name: ship_info_id_ship_info_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ship_info_id_ship_info_seq OWNED BY ship_info.id_ship_info;


--
-- TOC entry 231 (class 1259 OID 24846)
-- Name: status; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE status (
    id_status integer NOT NULL,
    denomination character varying(30) NOT NULL,
    table_ character varying NOT NULL,
    shortcut character varying
);


ALTER TABLE status OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 24852)
-- Name: status_idStatus_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "status_idStatus_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "status_idStatus_seq" OWNER TO postgres;

--
-- TOC entry 2615 (class 0 OID 0)
-- Dependencies: 232
-- Name: status_idStatus_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "status_idStatus_seq" OWNED BY status.id_status;


--
-- TOC entry 233 (class 1259 OID 24854)
-- Name: store; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE store (
    id_store integer NOT NULL,
    denomination character varying(60) NOT NULL,
    coordinates character varying(80),
    address character varying(200) NOT NULL,
    phone character varying(80),
    id_district integer NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone,
    status integer NOT NULL
);


ALTER TABLE store OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 24857)
-- Name: store_id_store_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE store_id_store_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE store_id_store_seq OWNER TO postgres;

--
-- TOC entry 2616 (class 0 OID 0)
-- Dependencies: 234
-- Name: store_id_store_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE store_id_store_seq OWNED BY store.id_store;


--
-- TOC entry 185 (class 1259 OID 24684)
-- Name: user_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE user_roles (
    user_role_id integer NOT NULL,
    user_id integer NOT NULL,
    role character varying(45) NOT NULL
);


ALTER TABLE user_roles OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 24682)
-- Name: user_roles_user_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE user_roles_user_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE user_roles_user_role_id_seq OWNER TO postgres;

--
-- TOC entry 2617 (class 0 OID 0)
-- Dependencies: 184
-- Name: user_roles_user_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE user_roles_user_role_id_seq OWNED BY user_roles.user_role_id;


--
-- TOC entry 183 (class 1259 OID 24675)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users (
    user_id integer NOT NULL,
    user_name character varying(45) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(60) NOT NULL,
    enabled smallint DEFAULT 1 NOT NULL
);


ALTER TABLE users OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 24673)
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_user_id_seq OWNER TO postgres;

--
-- TOC entry 2618 (class 0 OID 0)
-- Dependencies: 182
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_user_id_seq OWNED BY users.user_id;


--
-- TOC entry 238 (class 1259 OID 25160)
-- Name: view_products; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW view_products AS
 SELECT ps.id_product,
    ps.name,
    ps.description,
    ps.code,
    ps.id_color,
    ps.price,
    ps.stock,
    ps.measure,
    ps.id_category,
    ps.id_status,
    ps.id_image,
    ps.created_at,
    ps.updated_at,
    ps.material,
    ps.finish,
    ps.id_purpose,
    ps.size,
    ps.item_box,
    ps.kg_meter,
    ps.id_enviroment,
    ps.price_sample,
    ps.name_clean
   FROM ( SELECT products.id_product,
            products.name,
            products.description,
            products.code,
            products.id_color,
            products.price,
            products.stock,
            products.measure,
            products.id_category,
            products.id_status,
            products.id_image,
            products.created_at,
            products.updated_at,
            products.material,
            products.finish,
            products.id_purpose,
            products.size,
            products.item_box,
            products.kg_meter,
            products.id_enviroment,
            products.price_sample,
            translate((products.name)::text, 'áéíóúÁÉÍÓÚäëïöüÄËÏÖÜñÑ'::text, 'aeiouAEIOUaeiouAEIOUNN'::text) AS name_clean
           FROM products) ps;


ALTER TABLE view_products OWNER TO postgres;

--
-- TOC entry 2294 (class 2604 OID 24864)
-- Name: id_category; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY category ALTER COLUMN id_category SET DEFAULT nextval('"category_idCategory_seq"'::regclass);


--
-- TOC entry 2295 (class 2604 OID 24865)
-- Name: id_color; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY color ALTER COLUMN id_color SET DEFAULT nextval('"color_idColor_seq"'::regclass);


--
-- TOC entry 2296 (class 2604 OID 24866)
-- Name: id_country; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY country ALTER COLUMN id_country SET DEFAULT nextval('country_id_country_seq'::regclass);


--
-- TOC entry 2297 (class 2604 OID 24867)
-- Name: id_discount; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY discount ALTER COLUMN id_discount SET DEFAULT nextval('"discount_idDiscount_seq"'::regclass);


--
-- TOC entry 2298 (class 2604 OID 24868)
-- Name: id_discount_purchase; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY discount_purchase ALTER COLUMN id_discount_purchase SET DEFAULT nextval('discount_purchase_id_discount_purchase_seq'::regclass);


--
-- TOC entry 2299 (class 2604 OID 24869)
-- Name: id_discount_user; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY discount_user ALTER COLUMN id_discount_user SET DEFAULT nextval('"discount_user_idDiscountUser_seq"'::regclass);


--
-- TOC entry 2300 (class 2604 OID 24870)
-- Name: id_district; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY district ALTER COLUMN id_district SET DEFAULT nextval('district_id_district_seq'::regclass);


--
-- TOC entry 2301 (class 2604 OID 24871)
-- Name: id_enviroment; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY enviroment ALTER COLUMN id_enviroment SET DEFAULT nextval('enviroment_id_enviroment_seq'::regclass);


--
-- TOC entry 2302 (class 2604 OID 24872)
-- Name: id_image; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY image ALTER COLUMN id_image SET DEFAULT nextval('image_idimage_seq'::regclass);


--
-- TOC entry 2303 (class 2604 OID 24873)
-- Name: id_ipn; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ipn ALTER COLUMN id_ipn SET DEFAULT nextval('ipn_id_ipn_seq'::regclass);


--
-- TOC entry 2304 (class 2604 OID 24874)
-- Name: id_offer; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY offer ALTER COLUMN id_offer SET DEFAULT nextval('"offer_idOffer_seq"'::regclass);


--
-- TOC entry 2305 (class 2604 OID 24875)
-- Name: id_order; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "order" ALTER COLUMN id_order SET DEFAULT nextval('order_id_order_seq'::regclass);


--
-- TOC entry 2306 (class 2604 OID 24876)
-- Name: id_order_detail; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY order_detail ALTER COLUMN id_order_detail SET DEFAULT nextval('order_detail_id_order_detail_seq'::regclass);


--
-- TOC entry 2307 (class 2604 OID 24877)
-- Name: id_palette; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY palette ALTER COLUMN id_palette SET DEFAULT nextval('palette_id_palette_seq'::regclass);


--
-- TOC entry 2308 (class 2604 OID 24878)
-- Name: id_payment; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY payment ALTER COLUMN id_payment SET DEFAULT nextval('payment_id_payment_seq'::regclass);


--
-- TOC entry 2309 (class 2604 OID 24879)
-- Name: id_product_discount; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY product_discount ALTER COLUMN id_product_discount SET DEFAULT nextval('product_discount_id_product_discount_seq'::regclass);


--
-- TOC entry 2312 (class 2604 OID 24882)
-- Name: id_purchase; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY purchase ALTER COLUMN id_purchase SET DEFAULT nextval('purchase_id_purchase_seq'::regclass);


--
-- TOC entry 2313 (class 2604 OID 24883)
-- Name: id_purpose; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY purpose ALTER COLUMN id_purpose SET DEFAULT nextval('purpose_id_purpose_seq'::regclass);


--
-- TOC entry 2314 (class 2604 OID 24884)
-- Name: id_rank; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rank ALTER COLUMN id_rank SET DEFAULT nextval('rank_id_rank_seq'::regclass);


--
-- TOC entry 2316 (class 2604 OID 24886)
-- Name: id_ship_info; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ship_info ALTER COLUMN id_ship_info SET DEFAULT nextval('ship_info_id_ship_info_seq'::regclass);


--
-- TOC entry 2317 (class 2604 OID 24887)
-- Name: id_status; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY status ALTER COLUMN id_status SET DEFAULT nextval('"status_idStatus_seq"'::regclass);


--
-- TOC entry 2318 (class 2604 OID 24888)
-- Name: id_store; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY store ALTER COLUMN id_store SET DEFAULT nextval('store_id_store_seq'::regclass);


--
-- TOC entry 2293 (class 2604 OID 24687)
-- Name: user_role_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_roles ALTER COLUMN user_role_id SET DEFAULT nextval('user_roles_user_role_id_seq'::regclass);


--
-- TOC entry 2291 (class 2604 OID 24678)
-- Name: user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN user_id SET DEFAULT nextval('users_user_id_seq'::regclass);


--
-- TOC entry 2535 (class 0 OID 24698)
-- Dependencies: 186
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY category (id_category, denomination, created_at, updated_at, status) FROM stdin;
2	Gris Procelánico	\N	\N	1
3	Porcelanato	\N	\N	1
4	Listel 	\N	\N	1
7	Mosaico	\N	\N	1
8	Flecha	\N	\N	1
9	Inserto	\N	\N	1
1	Cerámica	\N	\N	1
\.


--
-- TOC entry 2619 (class 0 OID 0)
-- Dependencies: 187
-- Name: category_idCategory_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"category_idCategory_seq"', 13, true);


--
-- TOC entry 2537 (class 0 OID 24703)
-- Dependencies: 188
-- Data for Name: color; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY color (id_color, denomination, created_at, updated_at, status, hex, class, d, class_m) FROM stdin;
1	MArron	\N	\N	1	CB7F7B	st0	M498.2,303l-60.6-12.9c2.5-12.4,3.9-25.2,3.9-38.4c0-5.3-0.2-10.5-0.6-15.6l61.8-5.4 C504.7,256.2,503.4,278,498.2,303z	cero
2	color2	\N	\N	1	BC5C4A	st1	M502.4,228.8l-61.8,5.4c-1.7-18.4-6-36.1-12.6-52.6l57.5-23.2C495,182.1,500.1,203.3,502.4,228.8z	uno
3	color3	\N	\N	1	8B2C25	st2	M250.8,0v62.1c-19.7,0.1-38.8,3.2-56.6,8.9L174.9,12C199.5,4.1,225,0.1,250.8,0z	dos
4	color4	\N	\N	1	673414	st3	M192.2,71.7c-17.4,5.7-33.6,13.9-48.4,24.1l-35.6-50.9c21-14.6,40.5-24.3,64.8-32.3L192.2,71.7z	tres
5	color5	\N	\N	1	703A13	st4	M142.2,97c-14.8,10.5-28,23-39.2,37.2l-49-38.2c15.8-20.1,31.6-35.1,52.5-49.8L142.2,97z	cuatro
6	color6	\N	\N	1	7C3C22	st5	M101.8,135.8c-11,14.2-20,30-26.7,47l-57.9-22.2c9.2-23.9,20-42.8,35.7-63L101.8,135.8z	cinco
7	color7	\N	\N	1	76511D	st6	M74.4,184.7c-6.3,16.6-10.3,34.3-11.7,52.8l-61.9-4.3c1.9-25.5,6.6-46.8,15.7-70.7L74.4,184.7z	seis
8	color8	\N	\N	1	3B392A	st7	M66.7,293.4l-60.4,14c-5.7-25-7.4-46.7-5.7-72.2l61.9,4.3c-0.3,4.1-0.4,8.2-0.4,12.3 C62.2,266.1,63.7,280,66.7,293.4z	siete
12	color12	\N	\N	1	927E61	st11	M224.4,439.4l-8.6,61.4c-25.3-3.6-46.2-9.8-69.5-20.6l26.2-56.1C188.7,431.5,206.1,436.8,224.4,439.4z	once
14	color14	\N	\N	1	A5A28C	st13	M361.2,478.3c-23,11.1-43.8,17.7-69.1,21.8l-9.7-61.2c18.2-3,35.5-8.5,51.6-16.3L361.2,478.3z	trece
11	color11	\N	\N	1	6E6046	st10	M170.7,423.2l-26.2,56.1c-23.1-10.9-41.3-22.9-60.4-40l41.5-46.1C139,405.3,154.2,415.4,170.7,423.2z	diez
10	color108	\N	\N	1	8C8371	st9	M124.1,392L82.6,438c-19.1-17.3-35.3-37.4-48.3-59.6l53.7-31C97.7,364,109.9,379.1,124.1,392z	nueve
13	color13	\N	\N	1	7B765E	st12	M290.2,500.4c-13.5,2.1-26,3.1-38.1,3.1c-10.9,0-22.2-0.8-34.3-2.5l8.6-61.4c8.3,1.1,16.8,1.7,25.4,1.7 c9.7,0,19.3-0.7,28.7-2.2L290.2,500.4z	doce
15	color15	\N	\N	1	D4CFA2	st14	M422.7,436.4c-18.8,17.4-36.7,29.7-59.7,41l-27.1-55.7c16.3-8.1,31.3-18.4,44.6-30.7L422.7,436.4z	catorce
16	color16	\N	\N	1	D6D6C1	st15	M469.2,378.4c-12.9,22.1-26.4,39.2-45.1,56.7l-42.3-45.3c13.1-12.4,24.5-26.6,33.7-42.3L469.2,378.4z	quince
25	color25	\N	\N	1	8D998F	st24	M152.3,175.2c-7.1,9.2-13,19.5-17.3,30.5l-53.1-20.4c6.4-16.3,15.1-31.5,25.6-45.1L152.3,175.2z	veinticuatro
17	color17	\N	\N	1	AD7F6F	st16	M497.7,305c-5.5,25.2-14.7,49.3-27.5,71.7l-53.7-31c9.4-16.5,16.4-34.5,20.6-53.6L497.7,305z	dieciseis
20	color20	\N	\N	1	C97C20	st19	M391.7,42.5L356.9,94c-14.9-10-31.3-17.9-48.8-23.3l18.1-59.4C350.8,18.9,370.4,28.2,391.7,42.5z	diecinueve
21	color21	\N	\N	1	C29327	st20	M324.4,10.7l-18.1,59.4h0c-17-5.1-34.9-7.8-53.5-7.9V0C278.4,0.1,299.9,3.3,324.4,10.7z	veinte
18	color18	\N	\N	1	CF4310	st17	M484.7,156.5l-57.5,23.2c-6.9-16.9-16.2-32.5-27.5-46.6L448,94.1C464,114,475.1,132.8,484.7,156.5z	diecisiete
19	color19	\N	\N	1	C05F16	st18	M446.7,92.5l-48.3,39.1c-11.5-14-24.9-26.3-39.9-36.5l34.7-51.5C414.5,58,430.6,72.7,446.7,92.5z	dieciocho
24	color24	\N	\N	1	BAD69E	st23	M179,149.5c-9.6,6.8-18.2,15-25.5,24.2l-44.8-35c10.8-13.6,23.5-25.7,37.7-35.7L179,149.5z	veintitres
27	color27	\N	\N	1	A9A9A9	st26	M129.2,279l-55.4,12.8c-2.9-12.9-4.4-26.2-4.4-40c0-4,0.1-7.9,0.4-11.8l56.7,4c-0.2,2.6-0.2,5.2-0.2,7.8 C126.2,261.1,127.3,270.2,129.2,279z	veintiseis
29	color29	\N	\N	1	B5BFC0	st28	M167,344.3l-38,42.2c-13.6-12.4-25.3-26.8-34.7-42.8l49.2-28.4C149.9,326.1,157.8,335.9,167,344.3z	veintiocho
28	color28	\N	\N	1	BFC4C7	st27	M142.5,313.6L93.3,342c-8.5-14.9-15-31.2-19-48.3l55.4-12.8C132.4,292.5,136.8,303.5,142.5,313.6z	veintisiete
30	color30	\N	\N	1	A4AFBF	st29	M197.8,365.1l-24,51.5c-15.8-7.5-30.4-17.2-43.3-28.7l38-42.2C177.2,353.5,187.1,360,197.8,365.1z	veintinueve
9	color99	\N	\N	1	82766C	st8	M87,345.6l-53.7,31c-12.7-22.2-20.7-42.5-26.5-67.4l60.4-13.9C71.4,313.2,78.1,330.1,87,345.6z	ocho
31	color31	\N	\N	1	7A7FA3	st30	M233.3,376l-7.9,56.3c-17.5-2.5-34.3-7.6-49.8-14.8l24-51.5C210.1,370.8,221.4,374.2,233.3,376z	treinta
41	color41	\N	\N	1	D6CAB0	st40	M352.9,100l-31.8,47.1c-9.7-6.4-20.4-11.6-31.7-15.1L306,77.6C322.8,82.8,338.6,90.4,352.9,100z	cuarenta
23	color23	\N	\N	1	90B56B	st22	M212,132.6c-11.3,3.8-21.8,9.1-31.4,15.7L148,101.8c14.2-9.8,29.8-17.7,46.5-23.2L212,132.6z	veintidos
26	color26	\N	\N	1	CDD4C1	st25	M134.2,207.6c-4.1,10.8-6.7,22.3-7.6,34.3l-56.7-4c1.3-17.7,5.2-34.7,11.2-50.7L134.2,207.6z	veinticinco
33	color33	\N	\N	1	7F6954	st32	M330.9,416.1c-15.4,7.4-32.1,12.8-49.6,15.6l-8.9-56.1c11.8-2,23.1-5.6,33.5-10.6L330.9,416.1z	treintaydos
32	color32	\N	\N	1	7C7F88	st31	M279.3,432.1c-9,1.4-18.2,2.1-27.5,2.1c-8.3,0-16.4-0.6-24.4-1.6l7.9-56.2c5.4,0.7,10.9,1.1,16.5,1.1c6.3,0,12.6-0.5,18.6-1.4L279.3,432.1z	treintayuno
34	color34	\N	\N	1	A27A59	st33	M375.4,385.8c-12.7,11.8-27.1,21.7-42.8,29.5l-24.9-51.1c10.6-5.3,20.3-12,29-20L375.4,385.8z	treintaytres
36	color36	\N	\N	1	BF9067	st35	M430,290.6c-4,18.3-10.7,35.6-19.7,51.5l-49.2-28.4c6.1-10.7,10.6-22.5,13.4-34.9L430,290.6z	treintaycinco
37	color37	\N	\N	1	C8A280	st36	M434.1,251.8c0,12.6-1.3,25-3.7,36.9l-55.6-11.8c1.6-8.1,2.5-16.5,2.5-25c0-3.4-0.1-6.7-0.4-10l56.6-4.9 C433.9,241.7,434.1,246.7,434.1,251.8z	treintayseis
35	color35	\N	\N	1	C47F52	st34	M409.3,343.8c-8.8,15.1-19.7,28.8-32.4,40.6l-38.7-41.5c8.5-8.1,15.9-17.3,21.9-27.5L409.3,343.8z	treintaycuatro
38	color38	\N	\N	1	C4A988	st37	M433.4,234.8l-56.6,5c-1.1-12-4-23.4-8.2-34.2l52.7-21.3C427.6,200.2,431.7,217.1,433.4,234.8z	treintaysiete
39	color39	\N	\N	1	B9AA9E	st38	M420.5,182.4L420.5,182.4l-52.7,21.3c-4.5-11-10.6-21.1-17.9-30.2l44.1-35.7 C404.9,151.2,413.8,166.2,420.5,182.4z	treintayocho
40	color40	\N	\N	1	CCB8A0	st39	M392.8,136.2l-44.2,35.8c-7.5-9.1-16.2-17.1-25.9-23.7l31.8-47.1C368.9,110.9,381.8,122.7,392.8,136.2z	treintaynueve
22	color22	\N	\N	1	7ABFA5	st21	M250.8,69.4v56.8c-12.8,0.1-25.2,2.1-36.8,5.8l-17.6-54C213.6,72.5,231.8,69.5,250.8,69.4z	veintiuno
42	color42	\N	\N	1	EDE0C2	st41	M304.1,77l-16.6,54.3c-11-3.3-22.7-5.1-34.7-5.1V69.4C270.6,69.5,287.8,72.2,304.1,77z	cuarentayuno
\.


--
-- TOC entry 2620 (class 0 OID 0)
-- Dependencies: 189
-- Name: color_idColor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"color_idColor_seq"', 16, true);


--
-- TOC entry 2539 (class 0 OID 24711)
-- Dependencies: 190
-- Data for Name: country; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY country (id_country, country_code, name) FROM stdin;
1	AD	ANDORRA
2	AE	EMIRATOS ÁRABES UNIDOS
3	AF	AFGANISTáN
4	AG	ANTIGUA Y BARBUDA
5	AI	ANGUILLA
6	AL	ALBANIA
7	AM	ARMENIA
8	AN	ANTILLAS HOLANDESAS
9	AO	ANGOLA
10	AQ	ANTáRTIDA
11	AR	ARGENTINA
12	AS	SAMOA AMERICANA
13	AT	AUSTRIA
14	AU	AUSTRALIA
15	AW	ARUBA
16	AX	ISLAS GLAND
17	AZ	AZERBAIYáN
18	BA	BOSNIA Y HERZEGOVINA
19	BB	BARBADOS
20	BD	BANGLADESH
21	BE	BéLGICA
22	BF	BURKINA FASO
23	BG	BULGARIA
24	BH	BAHRéIN
25	BI	BURUNDI
26	BJ	BENIN
27	BM	BERMUDAS
28	BN	BRUNéI
29	BO	BOLIVIA
30	BR	BRASIL
31	BS	BAHAMAS
32	BT	BHUTáN
33	BV	ISLA BOUVET
34	BW	BOTSUANA
35	BY	BIELORRUSIA
36	BZ	BELICE
37	CA	CANADá
38	CC	ISLAS COCOS
39	CD	REPúBLICA DEMOCRáTICA DEL CONGO
40	CF	REPúBLICA CENTROAFRICANA
41	CG	CONGO
42	CH	SUIZA
43	CI	COSTA DE MARFIL
44	CK	ISLAS COOK
45	CL	CHILE
46	CM	CAMERúN
47	CN	CHINA
48	CO	COLOMBIA
49	CR	COSTA RICA
50	CS	SERBIA Y MONTENEGRO
51	CU	CUBA
52	CV	CABO VERDE
53	CX	ISLA DE NAVIDAD
54	CY	CHIPRE
55	CZ	REPúBLICA CHECA
56	DE	ALEMANIA
57	DJ	YIBUTI
58	DK	DINAMARCA
59	DM	DOMINICA
60	DO	REPúBLICA DOMINICANA
61	DZ	ARGELIA
62	EC	ECUADOR
63	EE	ESTONIA
64	EG	EGIPTO
65	EH	SAHARA OCCIDENTAL
66	ER	ERITREA
67	ES	ESPAñA
68	ET	ETIOPíA
69	FI	FINLANDIA
70	FJ	FIYI
71	FK	ISLAS MALVINAS
72	FM	MICRONESIA
73	FO	ISLAS FEROE
74	FR	FRANCIA
75	GA	GABóN
76	GB	REINO UNIDO
77	GD	GRANADA
78	GE	GEORGIA
79	GF	GUAYANA FRANCESA
80	GH	GHANA
81	GI	GIBRALTAR
82	GL	GROENLANDIA
83	GM	GAMBIA
84	GN	GUINEA
85	GP	GUADALUPE
86	GQ	GUINEA ECUATORIAL
87	GR	GRECIA
88	GS	ISLAS GEORGIAS DEL SUR Y SANDWICH DEL SUR
89	GT	GUATEMALA
90	GU	GUAM
91	GW	GUINEA-BISSAU
92	GY	GUYANA
93	HK	HONG KONG
94	HM	ISLAS HEARD Y MCDONALD
95	HN	HONDURAS
96	HR	CROACIA
97	HT	HAITí
98	HU	HUNGRíA
99	ID	INDONESIA
100	IE	IRLANDA
101	IL	ISRAEL
102	IN	INDIA
103	IO	TERRITORIO BRITáNICO DEL OCéANO ÍNDICO
104	IQ	IRAQ
105	IR	IRáN
106	IS	ISLANDIA
107	IT	ITALIA
108	JM	JAMAICA
109	JO	JORDANIA
110	JP	JAPóN
111	KE	KENIA
112	KG	KIRGUISTáN
113	KH	CAMBOYA
114	KI	KIRIBATI
115	KM	COMORAS
116	KN	SAN CRISTóBAL Y NEVIS
117	KP	COREA DEL NORTE
118	KR	COREA DEL SUR
119	KW	KUWAIT
120	KY	ISLAS CAIMáN
121	KZ	KAZAJSTáN
122	LA	LAOS
123	LB	LíBANO
124	LC	SANTA LUCíA
125	LI	LIECHTENSTEIN
126	LK	SRI LANKA
127	LR	LIBERIA
128	LS	LESOTHO
129	LT	LITUANIA
130	LU	LUXEMBURGO
131	LV	LETONIA
132	LY	LIBIA
133	MA	MARRUECOS
134	MC	MóNACO
135	MD	MOLDAVIA
136	MG	MADAGASCAR
137	MH	ISLAS MARSHALL
138	MK	ARY MACEDONIA
139	ML	MALí
140	MM	MYANMAR
141	MN	MONGOLIA
142	MO	MACAO
143	MP	ISLAS MARIANAS DEL NORTE
144	MQ	MARTINICA
145	MR	MAURITANIA
146	MS	MONTSERRAT
147	MT	MALTA
148	MU	MAURICIO
149	MV	MALDIVAS
150	MW	MALAWI
151	MX	MéXICO
152	MY	MALASIA
153	MZ	MOZAMBIQUE
154	NA	NAMIBIA
155	NC	NUEVA CALEDONIA
156	NE	NíGER
157	NF	ISLA NORFOLK
158	NG	NIGERIA
159	NI	NICARAGUA
160	NL	PAíSES BAJOS
161	NO	NORUEGA
162	NP	NEPAL
163	NR	NAURU
164	NU	NIUE
165	NZ	NUEVA ZELANDA
166	OM	OMáN
167	PA	PANAMá
168	PE	PERú
169	PF	POLINESIA FRANCESA
170	PG	PAPúA NUEVA GUINEA
171	PH	FILIPINAS
172	PK	PAKISTáN
173	PL	POLONIA
174	PM	SAN PEDRO Y MIQUELóN
175	PN	ISLAS PITCAIRN
176	PR	PUERTO RICO
177	PS	PALESTINA
178	PT	PORTUGAL
179	PW	PALAU
180	PY	PARAGUAY
181	QA	QATAR
182	RE	REUNIóN
183	RO	RUMANIA
184	RU	RUSIA
185	RW	RUANDA
186	SA	ARABIA SAUDí
187	SB	ISLAS SALOMóN
188	SC	SEYCHELLES
189	SD	SUDáN
190	SE	SUECIA
191	SG	SINGAPUR
192	SH	SANTA HELENA
193	SI	ESLOVENIA
194	SJ	SVALBARD Y JAN MAYEN
195	SK	ESLOVAQUIA
196	SL	SIERRA LEONA
197	SM	SAN MARINO
198	SN	SENEGAL
199	SO	SOMALIA
200	SR	SURINAM
201	ST	SANTO TOMé Y PRíNCIPE
202	SV	EL SALVADOR
203	SY	SIRIA
204	SZ	SUAZILANDIA
205	TC	ISLAS TURCAS Y CAICOS
206	TD	CHAD
207	TF	TERRITORIOS AUSTRALES FRANCESES
208	TG	TOGO
209	TH	TAILANDIA
210	TJ	TAYIKISTáN
211	TK	TOKELAU
212	TL	TIMOR ORIENTAL
213	TM	TURKMENISTáN
214	TN	TúNEZ
215	TO	TONGA
216	TR	TURQUíA
217	TT	TRINIDAD Y TOBAGO
218	TV	TUVALU
219	TW	TAIWáN
220	TZ	TANZANIA
221	UA	UCRANIA
222	UG	UGANDA
223	UM	ISLAS ULTRAMARINAS DE ESTADOS UNIDOS
224	US	ESTADOS UNIDOS
225	UY	URUGUAY
226	UZ	UZBEKISTáN
227	VA	CIUDAD DEL VATICANO
228	VC	SAN VICENTE Y LAS GRANADINAS
229	VE	VENEZUELA
230	VG	ISLAS VíRGENES BRITáNICAS
231	VI	ISLAS VíRGENES DE LOS ESTADOS UNIDOS
232	VN	VIETNAM
233	VU	VANUATU
234	WF	WALLIS Y FUTUNA
235	WS	SAMOA
236	YE	YEMEN
237	YT	MAYOTTE
238	ZA	SUDáFRICA
239	ZM	ZAMBIA
240	ZW	ZIMBABUE
\.


--
-- TOC entry 2621 (class 0 OID 0)
-- Dependencies: 191
-- Name: country_id_country_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('country_id_country_seq', 240, true);


--
-- TOC entry 2541 (class 0 OID 24716)
-- Dependencies: 192
-- Data for Name: discount; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY discount (id_discount, code, description, date_init, date_end, id_calcu_base, aliquot, status, use_limit, type_user, created_at, updated_at) FROM stdin;
3	Rebaja por transporte	si	2016-02-17 18:12:00	2016-07-02 18:12:00	2	3000	1	2	1	\N	\N
2	Primera Compra	ajar	2016-02-17 17:57:00	2016-05-31 17:57:00	1	0.5	1	1	1	\N	\N
1	11	Clientes Especiales	2016-02-07 15:30:00	2015-05-31 03:00:00	1	3	1	1	2	\N	\N
\.


--
-- TOC entry 2622 (class 0 OID 0)
-- Dependencies: 193
-- Name: discount_idDiscount_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"discount_idDiscount_seq"', 3, true);


--
-- TOC entry 2543 (class 0 OID 24724)
-- Dependencies: 194
-- Data for Name: discount_purchase; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY discount_purchase (id_discount_purchase, id_discount, id_purchase, discount, created_at, updated_at) FROM stdin;
\.


--
-- TOC entry 2623 (class 0 OID 0)
-- Dependencies: 195
-- Name: discount_purchase_id_discount_purchase_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('discount_purchase_id_discount_purchase_seq', 1, false);


--
-- TOC entry 2545 (class 0 OID 24732)
-- Dependencies: 196
-- Data for Name: discount_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY discount_user (id_discount_user, id_discount, id_user, status, created_at, updated_at) FROM stdin;
116	1	2	1	2016-07-14 15:58:02	2016-07-14 15:58:02
117	1	1	1	2016-07-14 15:58:02	2016-07-14 15:58:02
\.


--
-- TOC entry 2624 (class 0 OID 0)
-- Dependencies: 197
-- Name: discount_user_idDiscountUser_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"discount_user_idDiscountUser_seq"', 117, true);


--
-- TOC entry 2547 (class 0 OID 24737)
-- Dependencies: 198
-- Data for Name: district; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY district (id_district, denomination, created_at, updated_at) FROM stdin;
1	Arica y Parinacota	\N	\N
2	Tarapacá	\N	\N
3	Antofagasta	\N	\N
4	Atacama	\N	\N
5	Coquimbo	\N	\N
6	Valparaíso	\N	\N
7	Metropolitana de Santiago	\N	\N
8	O'Higgins	\N	\N
9	Maule	\N	\N
10	Bío-Bío	\N	\N
11	La Araucanía	\N	\N
12	Los Ríos	\N	\N
13	Los Lagos	\N	\N
14	Aysén	\N	\N
15	Magallanes	\N	\N
\.


--
-- TOC entry 2625 (class 0 OID 0)
-- Dependencies: 199
-- Name: district_id_district_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('district_id_district_seq', 15, true);


--
-- TOC entry 2549 (class 0 OID 24742)
-- Dependencies: 200
-- Data for Name: enviroment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY enviroment (id_enviroment, denomination, created_at, updated_at, status, id_image) FROM stdin;
6	cocina	\N	\N	1	244
2	comedor	\N	\N	1	245
4	living	\N	\N	1	247
3	piscina	\N	\N	1	248
1	Baño	\N	\N	1	243
5	fachada	\N	\N	1	246
\.


--
-- TOC entry 2626 (class 0 OID 0)
-- Dependencies: 201
-- Name: enviroment_id_enviroment_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('enviroment_id_enviroment_seq', 11, true);


--
-- TOC entry 2627 (class 0 OID 0)
-- Dependencies: 181
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('hibernate_sequence', 113, true);


--
-- TOC entry 2628 (class 0 OID 0)
-- Dependencies: 237
-- Name: id_product_offer_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('id_product_offer_seq', 1, false);


--
-- TOC entry 2629 (class 0 OID 0)
-- Dependencies: 235
-- Name: id_product_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('id_product_seq', 3, true);


--
-- TOC entry 2630 (class 0 OID 0)
-- Dependencies: 236
-- Name: id_relationated_product_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('id_relationated_product_seq', 3, true);


--
-- TOC entry 2551 (class 0 OID 24747)
-- Dependencies: 202
-- Data for Name: image; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY image (id_image, imagefile, created_at, updated_at) FROM stdin;
71	BUD_GRIS_60X60_GP.jpg	\N	\N
192	BLANCO_BRILLANTE_RECT._30X602.jpg	\N	\N
195	BUD_ARENA_60X60_GP.tif	\N	\N
198	BUD-OXIDO-60X60-GP.jpg	\N	\N
201	CALIZA_BEIGE__45X45.jpg	\N	\N
204	CASTANÌO-MIX-45X45.jpg	\N	\N
207	CASTANÌO-MIX-45X45.jpg	\N	\N
210	CEMENTO_ARENA__60X60_GP.jpg	\N	\N
213	DECO_MOTIVES_21,6X21,6.jpg	\N	\N
216	flor_gris.jpg	\N	\N
219	GLOSS-WHITE-34X60.jpg	\N	\N
222	JAZZ-BLANCO-36X36.jpg	\N	\N
225	KELTIC_SMOKE_60X60_GP.jpg	\N	\N
228	LOFT_IVORY_60X60_GP.jpg	\N	\N
231	LOFT_IVORY_60X60_GP.jpg	\N	\N
234	MIX_COLOR_60X60.jpg	\N	\N
237	OLMO-MIEL-20X120-GP.jpg	\N	\N
240	PORTLAND_VISON_60X60_GP.jpg	\N	\N
243	ambiente-bano.jpg	\N	\N
246	ambiente-fachada.jpg	\N	\N
249	Flecha-Lirio-Azul-8x25.jpg	\N	\N
252	Flecha_Ramas_8x25.jpg	\N	\N
255	Flecha-DelfiÌn-8x25.jpg	\N	\N
258	Flecha-Cielo-8x25.jpg	\N	\N
261	Flecha-Lirio-Verde-8x25.jpg	\N	\N
264	Flecha_OtonÌo_8x25.tif	\N	\N
267	Flecha-Primavera-8x25.jpg	\N	\N
270	Flecha-Tetera-8x25.jpg	\N	\N
273	Inserto_Poppy_Rosso_27X45.jpg	\N	\N
276	Listel_Almibar_7x35.jpg	\N	\N
279	Listel_Cacerolas_7x35.jpg	\N	\N
282	Listel_Citrique_7x35.jpg	\N	\N
285	Listel_frutas_7x35.jpg	\N	\N
288	Listel_Lemon_7X35.jpg	\N	\N
291	Listel_Ocean_14,5X26.jpg	\N	\N
294	Listel_Petalo_Azul_7x35.jpg	\N	\N
297	Listel_Piscis_14,5X26.jpg	\N	\N
300	Listel_Samoa_7x35.jpg	\N	\N
303	Listel_Poseidon_14,5X26.bmp	\N	\N
306	MALLA_MAR.METAL_30x30.jpg	\N	\N
309	MALLA_M._CAFE_30X30.jpg	\N	\N
312	MALLA_M._METAZUL_30X30.jpg	\N	\N
315	MALLA_V_ARMONIA_30x30.jpg	\N	\N
318	MALLA_V._HUMO_30X30.jpg	\N	\N
321	MALLA_V._NARANJO_30X30.jpg	\N	\N
193	BLANCO_SATINADO_34X60.jpg	\N	\N
196	BLANCO-SATINADO-RECT.-30X60-17.43.15.png	\N	\N
199	CEMENTO_ARENA__60X60_GP.jpg	\N	\N
202	CEMENTO_ARENA__60X60_GP.jpg	\N	\N
205	CEMENTO_ARENA__60X60_GP.jpg	\N	\N
208	CASTANO-MIX-45X45.jpg	\N	\N
211	CEMENTO-MARFIL-60X60-GP.jpg	\N	\N
214	FACHALETA_FANTASY_WHITE__27X45.jpg	\N	\N
217	Flor_Gris_45x45.jpg	\N	\N
220	GRAN_GRANITO_GRIS_59x59.jpg	\N	\N
223	KELTIC_BROWN_60X60_GP.jpg	\N	\N
226	LENGA_NATIVA_45X45.JPG	\N	\N
229	LOFT_BEIGE_60X60.jpg	\N	\N
232	PORTLAND_IVORY_60X60_GP.jpg	\N	\N
235	MIX_GREY_20X60_GP.jpg	\N	\N
238	OLMO_NEGRO_20X12_GP.jpg	\N	\N
241	SOFT-COLOR-27X45.jpg	\N	\N
244	ambiente-cocina.jpg	\N	\N
247	ambiente-living.jpg	\N	\N
250	Flecha-Jarron-Azul-8X25.jpg	\N	\N
253	Flecha-Rombo-Azul-8x25.jpg	\N	\N
256	Flecha-Campestre-8x25.jpg	\N	\N
259	Flecha-Cocina8x25.jpg	\N	\N
262	Flecha_Mosaico_8x25.jpg	\N	\N
265	Flecha-otono.jpg	\N	\N
268	Flecha-Rosa-8x25.jpg	\N	\N
271	Flecha-Vasija-8x25.jpg	\N	\N
274	Inserto_Ramage_Rouge_27x45.jpg	\N	\N
277	Listel_Aqua__7x35.jpg	\N	\N
280	Listel_Cazoleta_Beige_7x35.jpg	\N	\N
283	Listel_Corrali_Beige_7x35.jpg	\N	\N
286	Listel_Frutilla_Beige_7X35.jpg	\N	\N
289	Listel_London_Arena_7x35.jpg	\N	\N
292	Listel-Olas_14,5X26.jpg	\N	\N
295	Listel_Petalo_Guinda_7x35.jpg	\N	\N
298	Listel_Rafaella_Beige_7X35.jpg	\N	\N
301	Listel-Samoa-Azul-7x35.jpg	\N	\N
304	MALLA_M_ALERCE_30.5X30.5.jpg	\N	\N
307	MALLA_M._BEIGE_30,5X30,5.jpg	\N	\N
310	MALLA_M._CREMA_30,5X30,5.jpg	\N	\N
313	MALLA_M._OPAL_30,5X30,5.jpg	\N	\N
316	MALLA_V._COBALTO_30X30.jpg	\N	\N
319	MALLA_V_MARENGO_29,8X29,8.jpg	\N	\N
322	MALLA_V_ROBLE_30X30.JPG	\N	\N
1	CEMENTO ARENA 60X60 GP.jpg	\N	\N
2	CUOMO BLANCO 36X36.jpg	\N	\N
3	CUOMO BLANCO 45X45.jpg	\N	\N
4	HAYA ARENA 45X45.jpg	\N	\N
5	ITACA 60X60 GP.jpg	\N	\N
6	KELTIC SMOKE 30x60 GP.jpg	\N	\N
7	KELTIC SMOKE 60X60 GP.jpg	\N	\N
8	PEHUEN CORTE BLANCO 45X45.jpg	\N	\N
9	AGADIR AZUL 45X45.jpg	\N	\N
10	FLOWER BLUE 45X45.jpg	\N	\N
11	JAZZ AZUL 36X36.jpg	\N	\N
12	SKY BLUE 45X45.jpg	\N	\N
13	PORC. SPAZIO AZUL 30X60.jpg	\N	\N
14	BUD ARENA 60X60 GP.jpg	\N	\N
15	CALIZA BEIGE 45X45.jpg	\N	\N
16	FACHALETA BARLETT NATUR 34X60.jpg	\N	\N
17	FACHALETA FOLLIE NATURAL 34X60.jpg	\N	\N
18	FACHALETA ROMANCE BEIGE 27X45.jpg	\N	\N
19	GERVASONI BEIGE 60X60 GP.jpg	\N	\N
20	LOFT BEIGE 30x60 GP.jpg	\N	\N
21	LOFT BEIGE 60x60 GP.jpg	\N	\N
22	MAISON BEIGE 20X120 GP.jpg	\N	\N
23	MARA CLARA 45X45.jpg	\N	\N
24	NADOR BEIGE 45X45.jpg	\N	\N
25	OLMO BEIGE 20X120 GP.jpg	\N	\N
26	PIEDRA RIO BEIGE 45X45.jpg	\N	\N
27	PORC.SUPER BEIGE NANO 60x60.jpg	\N	\N
28	SOHO BEIGE 34X60.jpg	\N	\N
29	TRAVERTINO 36X36.jpg	\N	\N
30	TRAVERTINO 45X45.jpg	\N	\N
31	TRAVERTINO MATE MARFI 60X60 GP.jpg	\N	\N
32	CASTAÑO MIX 45X45.jpg	\N	\N
33	OLMO MIEL 20X120 GP.jpg	\N	\N
34	PRAGA BEIGE 60X60 GP.jpg	\N	\N
35	FACHALETA HARMONY BEIGE 27X45.jpg	\N	\N
36	MARA TOSTADO 45X45.jpg	\N	\N
37	BLANCO BRILLANTE 34X60.jpg	\N	\N
38	BLANCO BRILLANTE RECT 30X60 (5.jpg	\N	\N
39	BLANCO SATIN RECT. 30X60 (MV).jpg	\N	\N
40	BLANCO SATINADO 34X60.jpg	\N	\N
41	GLOSS WHITE 34X60.jpg	\N	\N
42	JAZZ BLANCO 36X36.jpg	\N	\N
43	LISO BLANCO 36X36.jpg	\N	\N
44	NACAR BLANCO 45X45.jpg	\N	\N
45	QATAR BLANCO 34X60.jpg	\N	\N
46	MOSAIK DUO 45X45.jpg	\N	\N
47	CUADROS NEGRO 36X36.jpg	\N	\N
48	CUADROS NEGRO 45X45.jpg	\N	\N
49	CUBO NEGRO 45X45.jpg	\N	\N
50	DECO MOTIVES MIX 21.6X21.6.jpg	\N	\N
51	FLOR NEGRO 36X36.jpg	\N	\N
52	FACHALETA SPA COGNAC 34X60.jpg	\N	\N
53	FRESNO AMERICANO 45X45.jpg	\N	\N
54	KELTIC BROWN 30x60 GP.jpg	\N	\N
55	KELTIC BROWN 60X60 GP.jpg	\N	\N
56	PARQUET CEDRO 45X45.jpg	\N	\N
57	LENGA NATIVA 45X45.jpg	\N	\N
58	OLMO NEGRO 20X120 GP.jpg	\N	\N
59	OXIDUM CUPRICO 60X60 GP.jpg	\N	\N
60	PARQUET CEDRO OSCURO 45X45.jpg	\N	\N
61	TARIMA NEGRO 20X120 GP.jpg	\N	\N
62	ZAGORA AZUL 45X45.jpg	\N	\N
63	MIX COLOR 60x60.jpg	\N	\N
64	MOSAIK COLOR 45X45.jpg	\N	\N
65	PIEDRA RIO COLOR 45X45.jpg	\N	\N
66	CEMENTO GRAFITO 60X60 GP.jpg	\N	\N
67	IBERICA OXIDO 45X45.jpg	\N	\N
68	NACAR GRAFITO 45X45.jpg	\N	\N
69	PIEDRA RIO GRIS 45X45.jpg	\N	\N
70	ABEDUL CENIZA 45X45.jpg	\N	\N
72	CIMENTA CENIZA 45X45.jpg	\N	\N
73	CONCEPT OUT GRIS 60X60 GP.jpg	\N	\N
74	CONCRETO GRIS MATE 60X60 GP.jpg	\N	\N
75	CONCRETO GRIS SPUL 60X60 GP.jpg	\N	\N
76	FACHALETA BRICK GRIS 34X60.jpg	\N	\N
77	FACHALETA FANTASY WHITE 27X45.jpg	\N	\N
78	FACHALETA HARMONY GRIS 27X45.jpg	\N	\N
79	FACHALETA ROMANCE GRIS 27X45.jpg	\N	\N
80	FEZ GRIS 45X45.jpg	\N	\N
81	FLOR GRIS 45X45.jpg	\N	\N
82	GRANITO GRIS SMARTILE 59X59.jpg	\N	\N
83	KELTIC GREY 30x60 GP.jpg	\N	\N
84	KELTIC GREY 60X60 GP.jpg	\N	\N
85	MAISON GRIS 20X120 GP.jpg	\N	\N
86	MIX GREY 20X60.jpg	\N	\N
87	PORTLAND GREY 30X60 GP.jpg	\N	\N
88	PORTLAND GREY 60X60 GP.jpg	\N	\N
89	REZATTO GRIS 45X45.jpg	\N	\N
90	SKY GREY 45X45.jpg	\N	\N
91	TECA PINTADO 45X45.jpg	\N	\N
92	SOFT COLOR 27X45.jpg	\N	\N
93	CEMENTO HABANO 60X60 GP.jpg	\N	\N
94	CEMENTO MARFIL 60X60 GP.jpg	\N	\N
95	LOFT IVORY 30x60 GP.jpg	\N	\N
96	LOFT IVORY 60x60 GP.jpg	\N	\N
97	PORC.SUPER WHITE 60x60.jpg	\N	\N
98	PORTLAND IVORY 30X60 GP.jpg	\N	\N
99	PORTLAND IVORY 60X60 GP.jpg	\N	\N
100	ALELI MARRON 45X45.jpg	\N	\N
101	BUD OXIDO 60X60 GP.jpg	\N	\N
102	FACHALETA LAJA ZEN 27X45.jpg	\N	\N
103	FACHALETA LUAU NATURAL 34X60.jpg	\N	\N
104	FACHALETA TENTACION 27X45.jpg	\N	\N
105	OLMO RUSTICO 20X120 GP.jpg	\N	\N
106	CONCEPT OUT BLACK 60X60 GP.jpg	\N	\N
107	LISO NEGRO 36X36.jpg	\N	\N
108	PORC.SUPER BLACK NANO 60x60.jpg	\N	\N
109	GARDEN GREEN 45X45.jpg	\N	\N
110	PORTLAND VISON 30X60 GP.jpg	\N	\N
111	PORTLAND VISÓN 60X60 GP.jpg	\N	\N
112	LISTEL CITRIQUE 7X35.jpg	\N	\N
113	LISTEL LEMONS 7X35.jpg	\N	\N
114	FLECHA CHEF 8X25.jpg	\N	\N
115	LISTEL LONDON ARENA 7X35.jpg	\N	\N
116	MALLA M.CREMA(C077 SKS)305X305.jpg	\N	\N
117	FLECHA CALA 8X25.jpg	\N	\N
118	FLECHA DELFIN (DKJ1620) 8X25.jpg	\N	\N
119	FLECHA JARRON AZUL (DKJ518D) 8X25.jpg	\N	\N
120	FLECHA LIRIO AZUL (DK103A) 8X25.jpg	\N	\N
121	FLECHA RAMAS 8X25.jpg	\N	\N
122	FLECHA ROMBO AZUL (25F142W) 8X25.jpg	\N	\N
123	LISTEL AQUA 7X35.jpg	\N	\N
124	LISTEL AQUAMARINA 14.5X26.jpg	\N	\N
125	LISTEL FEZ PISCINA 14.5x26.jpg	\N	\N
126	LISTEL MOSAIK PISCINA 14.5X26.jpg	\N	\N
127	LISTEL OCEAN 14.5X26.jpg	\N	\N
128	LISTEL OLAS 14.5X26.jpg	\N	\N
129	LISTEL PETALO AZUL 7X35.jpg	\N	\N
130	LISTEL PISCIS 14.5X26.jpg	\N	\N
131	LISTEL POSEIDON 14.5X26.jpg	\N	\N
132	LISTEL SAMOA AZUL 7X35.jpg	\N	\N
133	MALLA M.METAZUL (MBC105)30X30.jpg	\N	\N
134	MALLA V ARMONIA (HFDS-J-347) 30X30.jpg	\N	\N
135	MALLA V.COBALTO(SP177)30X30.jpg	\N	\N
136	FLECHA MOSAICO 8X25.jpg	\N	\N
137	FLECHA CAMPESTRE (DKJ224A) 8X25.jpg	\N	\N
138	FLECHA CIELO (DK309D) 8X25.jpg	\N	\N
139	FLECHA COCINA (DKJ1177B) 8X25.jpg	\N	\N
140	FLECHA ORIENTAL (25F122W) 8X25.jpg	\N	\N
141	FLECHA OTOÑO (DKJ211A) 8X25.jpg	\N	\N
142	FLECHA PLATO (25F278W) 8X25.jpg	\N	\N
143	FLECHA ROSA (DKJ308) 8X25.jpg	\N	\N
144	FLECHA TABLA 8X25.jpg	\N	\N
145	FLECHA TETERA (25F102W) 8X25.jpg	\N	\N
146	FLECHA VASIJA (DKJ151) 8X25.jpg	\N	\N
147	INSERT MOZAIK BEIGE METAL36X36.jpg	\N	\N
148	INSERTO CUBICA MARFIL 36X36.jpg	\N	\N
149	LISTEL CACEROLAS 7X35.jpg	\N	\N
150	LISTEL CAZOLETA BEIGE 7X35.jpg	\N	\N
151	LISTEL FRUTAS 7X35.jpg	\N	\N
152	LISTEL FRUTILLA BEIGE 7X35.jpg	\N	\N
153	LISTEL GARRAFA BEIGE 7X35.jpg	\N	\N
154	LISTEL RAFAELLA BEIGE 7X35.jpg	\N	\N
155	LISTEL SAMANTHA ARENA 7X35.jpg	\N	\N
156	MALLA M. BIANCO (MBC003) 30X30.jpg	\N	\N
157	MALLA M.BEIGE(C019 SKS)305X305.jpg	\N	\N
158	MALLA M.METABEI(MBC104)30X30.jpg	\N	\N
159	FLECHA DALI (DKJ306) 8X25.jpg	\N	\N
160	MALLA M ALERCE (FH-C-018) 305X305.jpg	\N	\N
161	MALLA M. CAFE(C107 SKS)30X30.jpg	\N	\N
162	MOSAICO M CAFE Y BEIGE (H010).jpg	\N	\N
163	MOSAICO VM SEPIA (NO-182) 305.jpg	\N	\N
164	LISTEL CHARLOTTE 7X35.jpg	\N	\N
165	INS RAMAGE ROUGE SIN FIN 27X45.jpg	\N	\N
166	INSERTO RAMAGE ROUGE 27X45.jpg	\N	\N
167	INSERTO MOZAIK NEGRO 36X36.jpg	\N	\N
168	LISTEL SAMOA NEGRO 7X35.jpg	\N	\N
169	MALLA V.HUMO(WH005)30X30.jpg	\N	\N
170	LISTEL PETALO GUINDA 7x35.jpg	\N	\N
171	FLECHA COFFE 8X25.jpg	\N	\N
172	FLECHA JARRON (25F209W) 8X25.jpg	\N	\N
173	FLECHA PIÑA (25F193W) 8X25.jpg	\N	\N
174	LISTEL CORRALLI BEIGE 7X35.jpg	\N	\N
175	MALLA M. OPAL (LW001) 305X305.jpg	\N	\N
176	MALLA MAR.METAL(MBC117)30X30.jpg	\N	\N
177	MALLA V ROBLE (GD-4-23-W601) 30X30.jpg	\N	\N
178	MALLA V. MOCCA (GSD232) 305X305.jpg	\N	\N
179	FLECHA PRIMAVERA 8X25.jpg	\N	\N
180	MALLA V MARENGO (LY-8FX4804) 298X298.jpg	\N	\N
181	LISTEL SAMOA 7X35.jpg	\N	\N
182	LISTEL ALMIBAR 7X35.jpg	\N	\N
183	LISTEL ORANGES 7X35.jpg	\N	\N
184	MALLA V.NARANJO(KI 503)30X30.jpg	\N	\N
185	MALLA C BLACK (HJ 0002) 30X30.jpg	\N	\N
186	INSERTO POPPY ROSSO 27X45.jpg	\N	\N
187	FLECHA LIRIO VERDE (DK103B) 8X25.jpg	\N	\N
188	LISTEL PETALO VERDE 7X35.jpg	\N	\N
189	MALLA V ESPERANZA (GD-4-23-ESO5M) 30X30.jpg	\N	\N
190	MALLA V.ALGA(GSD231)30X30.jpg	\N	\N
191	BLANCO_BRILLANTE_RECT._30X60.jpg	\N	\N
194	BLANCO-SATINADO-RECT.-30X60-17.43.15.png	\N	\N
197	BUD-ARENA-60X60-GP.jpg	\N	\N
200	CEMENTO_ARENA__60X60_GP.jpg	\N	\N
203	CALIZA_BEIGE__45X45.jpg	\N	\N
206	CASTANÌO-MIX-45X45.jpg	\N	\N
209	CASTANÌO-MIX-45X45.jpg	\N	\N
212	CONCEPT_OUT_GRIS_60X60.jpg	\N	\N
215	FACHALETA_TENTACION_27X45.png	\N	\N
218	GERVASONI_BEIGE__60X60_GP.jpg	\N	\N
221	JAZZ-AZUL-36X36.jpg	\N	\N
224	KELTIC_GREY_60X60_GP.jpg	\N	\N
227	LISO-NEGRO-36X36.jpg	\N	\N
230	LOFT_IVORY_60X60_GP.jpg	\N	\N
233	Super_Beige_Nano_60x60.jpg	\N	\N
236	OLMO-BEIGE-20X120-GP.jpg	\N	\N
239	Spazio_Azul_30x60.jpg	\N	\N
242	TRAVERTINO_MARTE_MARFI_60X60_GP.jpg	\N	\N
245	ambiente-comedor.jpg	\N	\N
248	ambiente-piscina.jpg	\N	\N
251	Flecha-Jarron-8x25.jpg	\N	\N
254	Flecha-Cala-Azul-8x25.jpg	\N	\N
257	Flecha_Chef_8x25.jpg	\N	\N
260	Flecha-Dali-8x25.jpg	\N	\N
263	Flecha-Oriental-8x25.jpg	\N	\N
266	Flecha-Plato-8x25.jpg	\N	\N
269	Flecha_Tabla_8x25.jpg	\N	\N
272	Inserto_Cubica_Marfil_36x36.jpg	\N	\N
275	Inserto_Ramage_Rouge_Sin_Fin_27x45.jpg	\N	\N
278	Listel_Aquamarina14,5X26.jpg	\N	\N
281	Listel_Charlotte_7X35.jpg	\N	\N
284	Listel_Fez_Piscina_14,5X26.png	\N	\N
287	Listel_Garrafa_Beige__7x35.jpg	\N	\N
290	Listel_Mosaik_Piscina14,5X26.jpg	\N	\N
293	Listel_Orange_7x35.jpg	\N	\N
296	Listel_Petalo_Verde_7x35.jpg	\N	\N
299	Listel_Samantha_Arena_7x35.jpg	\N	\N
302	Listel_Samoa_Negro_7x35.jpg	\N	\N
305	MALLA_C_BLACK_30X30.jpg	\N	\N
308	MALLA_M._BIANCO_30X30.jpg	\N	\N
311	MALLA_M._METABEI_30X30.jpg	\N	\N
314	MALLA_V._ALGA_30X30.jpg	\N	\N
317	MALLA_V_ESPERANZA_30x30.jpg	\N	\N
320	MALLA_V._MOCCA__30,5X30,5.jpg	\N	\N
323	MOSAICO_VM_SEPIA_30,5X30,5.jpg	\N	\N
324	4 chavistas-valle_20170423_20172130.jpg	\N	\N
325	4 chavistas-valle_20170423_21121247.jpg	\N	\N
326	4_chavistas-valle_20170423_21140373.jpg	\N	\N
327	4_chavistas-valle_20170423_21162050.jpg	\N	\N
328	4_chavistas-valle_20170423_21171597.jpg	\N	\N
329	4_chavistas-valle_20170423_21222759.jpg	\N	\N
330	4_chavistas-valle_20170423_21245135.jpg	\N	\N
331	4_chavistas-valle_20170423_21280836.jpg	\N	\N
332	bici_hermosa_20170423_21500146.jpg	\N	\N
333	4_chavistas-valle_20170423_21514669.jpg	\N	\N
334	4_chavistas-valle_20170423_21520233.jpg	\N	\N
335	4_chavistas-valle_20170423_21550746.jpg	\N	\N
336	apoquindo_07-01-17_20170423_23262211.jpg	\N	\N
337	gastar_en_bici_20170423_23341730.png	\N	\N
338	ingles2_20170424_01072134.jpg	\N	\N
339	ingles3_20170424_08315504.jpg	\N	\N
340	bici_hermosa_20170424_15581357.jpg	\N	\N
341	bici_hermosa_20170424_15591539.jpg	\N	\N
342	bici_hermosa_20170424_16030028.jpg	\N	\N
343	gastar_en_bici_20170424_16034216.png	\N	\N
344	bici_hermosa_20170424_16065517.jpg	\N	\N
345	chavez_vive_20170424_16070127.jpg	\N	\N
346	bici_hermosa_20170424_20080201.jpg	\N	\N
\.


--
-- TOC entry 2631 (class 0 OID 0)
-- Dependencies: 203
-- Name: image_idimage_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('image_idimage_seq', 346, true);


--
-- TOC entry 2553 (class 0 OID 24752)
-- Dependencies: 204
-- Data for Name: ipn; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ipn (id_ipn, valor, fecha) FROM stdin;
258	Entrando al ipn complete version con id=2205790173 topic=payment	2016-07-28 14:58:04
259	payment	2016-07-28 14:58:04
260	approved	2016-07-28 14:58:10
261	Not paid yet. Do not release your item.	2016-07-28 14:58:10
262	$merchant_order_info["status"] == 200)	2016-07-28 14:58:10
263	Entrando al ipn complete version con id=2213619168 topic=payment	2016-07-28 16:26:26
264	payment	2016-07-28 16:26:26
265	approved	2016-07-28 16:26:30
266	Totally paid. Release your item.	2016-07-28 16:26:30
267	$merchant_order_info["status"] == 200)	2016-07-28 16:26:30
268	Entrando al ipn complete version con id=2213368892 topic=payment	2016-07-28 19:43:27
269	payment	2016-07-28 19:43:28
270	approved	2016-07-28 19:43:33
271	Entrando al ipn complete version con id=2213368892 topic=payment	2016-07-28 19:44:01
272	payment	2016-07-28 19:44:01
273	approved	2016-07-28 19:44:06
274	Entrando al ipn complete version con id=2213368892 topic=payment	2016-07-28 20:25:44
275	payment	2016-07-28 20:25:44
276	approved	2016-07-28 20:25:49
277	Entrando al ipn complete version con id=2213368892 topic=payment	2016-07-28 20:26:26
278	payment	2016-07-28 20:26:26
279	approved	2016-07-28 20:26:31
280	Entrando al ipn complete version con id=2213368892 topic=payment	2016-07-28 20:28:19
281	payment	2016-07-28 20:28:20
282	approved	2016-07-28 20:28:23
283	Entrando al ipn complete version con id=2213368892 topic=payment	2016-07-28 20:28:32
284	payment	2016-07-28 20:28:32
285	approved	2016-07-28 20:28:37
286	Entrando al ipn complete version con id=2213368892 topic=payment	2016-07-28 20:32:14
287	payment	2016-07-28 20:32:15
288	approved	2016-07-28 20:32:20
289	Entrando al ipn complete version con id=2213368892 topic=payment	2016-07-28 20:32:40
290	payment	2016-07-28 20:32:40
291	approved	2016-07-28 20:32:44
292	Entrando al ipn complete version con id=2213368892 topic=payment	2016-07-28 20:39:18
293	payment	2016-07-28 20:39:18
294	approved	2016-07-28 20:39:22
295	Entrando al ipn complete version con id=2213368892 topic=payment	2016-07-28 20:40:43
296	payment	2016-07-28 20:40:43
297	approved	2016-07-28 20:40:48
298	Totally paid. Release your item.	2016-07-28 20:40:48
299	Entrando al ipn complete version con id=2213368892 topic=payment	2016-07-28 20:43:30
300	payment	2016-07-28 20:43:30
301	approved	2016-07-28 20:43:34
302	Totally paid. Release your item.	2016-07-28 20:43:34
303	Entrando al ipn complete version con id=2213368892 topic=payment	2016-07-28 20:45:56
304	payment	2016-07-28 20:45:56
305	approved	2016-07-28 20:46:01
306	Totally paid. Release your item.	2016-07-28 20:46:01
307	Entrando al ipn complete version con id=2213368892 topic=payment	2016-07-28 20:48:20
308	payment	2016-07-28 20:48:20
309	approved	2016-07-28 20:48:24
310	Totally paid. Release your item.	2016-07-28 20:48:24
311	Entrando al ipn complete version con id=2213368892 topic=payment	2016-07-28 20:48:39
312	payment	2016-07-28 20:48:39
313	approved	2016-07-28 20:48:43
314	Totally paid. Release your item.	2016-07-28 20:48:43
315	Entrando al ipn complete version con id=2213368892 topic=payment	2016-07-28 20:53:13
316	payment	2016-07-28 20:53:13
317	approved	2016-07-28 20:53:19
318	Totally paid. Release your item.	2016-07-28 20:53:19
319	$merchant_order_info["status"] == 200)	2016-07-28 20:53:19
320	Entrando al ipn complete version con id=2213368892 topic=payment	2016-07-28 20:54:21
321	payment	2016-07-28 20:54:21
322	approved	2016-07-28 20:54:25
323	Entrando al ipn complete version con id=2213368892 topic=payment	2016-07-28 20:56:32
324	payment	2016-07-28 20:56:32
325	approved	2016-07-28 20:56:36
326	Entrando al ipn complete version con id=2213368892 topic=payment	2016-07-28 21:01:29
327	payment	2016-07-28 21:01:29
328	approved	2016-07-28 21:01:33
\.


--
-- TOC entry 2632 (class 0 OID 0)
-- Dependencies: 205
-- Name: ipn_id_ipn_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ipn_id_ipn_seq', 328, true);


--
-- TOC entry 2555 (class 0 OID 24760)
-- Dependencies: 206
-- Data for Name: migrations; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY migrations (migration, batch) FROM stdin;
2015_12_31_125759_create_user_table	1
2015_12_31_125909_create_password_resets_table	1
2016_01_04_194500_category_table	1
2016_01_04_194554_product_discount_table	1
2016_01_04_194658_discount_table	1
2016_01_06_143242_products_table	1
2016_01_13_205603_color_table	1
2016_01_14_025711_status_table	1
2016_01_19_152945_relationated_product	1
2016_01_22_022519_images_table	1
2016_02_04_020039_offer_table	1
2016_02_05_172712_product_offer_table	1
2016_02_08_180409_discount_user_table	1
\.


--
-- TOC entry 2556 (class 0 OID 24763)
-- Dependencies: 207
-- Data for Name: offer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY offer (id_offer, denomination, description, date_init, date_end, id_calcu_base, aliquot, status, created_at, updated_at) FROM stdin;
2	Ofertica	des2	2016-02-17 17:46:00	2016-06-30 17:46:00	1	50	1	\N	\N
1	Oferta1	Promoción del día de la madre 2017	2016-03-03 00:00:00	2016-08-31 23:59:00	1	6	1	\N	\N
\.


--
-- TOC entry 2633 (class 0 OID 0)
-- Dependencies: 208
-- Name: offer_idOffer_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"offer_idOffer_seq"', 2, true);


--
-- TOC entry 2558 (class 0 OID 24771)
-- Dependencies: 209
-- Data for Name: order; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "order" (id_order, date, id_user, status, created_at, updated_at, discount, id_ship_info) FROM stdin;
344	2016-07-28 13:47:01	1	3	2016-07-28 13:47:01	2016-07-28 13:47:01	1098.1992	1
346	2016-07-28 13:56:47	1	4	2016-07-28 13:56:47	2016-07-28 13:56:47	0	0
345	2016-07-28 13:56:16	1	3	2016-07-28 13:56:16	2016-07-28 13:56:16	0	0
329	2016-07-26 20:19:31	1	3	2016-07-26 20:19:31	2016-07-26 20:19:31	0	1
343	2016-07-28 13:44:31	1	3	2016-07-28 13:44:31	2016-07-28 13:44:31	0	0
347	2016-07-28 15:14:33	1	4	2016-07-28 15:14:33	2016-07-28 15:14:33	0	0
349	2016-07-28 15:14:33	1	4	2016-07-28 15:14:33	2016-07-28 15:14:33	15	0
\.


--
-- TOC entry 2559 (class 0 OID 24777)
-- Dependencies: 210
-- Data for Name: order_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY order_detail (id_order_detail, id_order, status, created_at, updated_at, id_product, quantity, price) FROM stdin;
1031	344	0	\N	\N	428	1	1227
1032	344	0	\N	\N	456	1	10339.0599999999995
1033	344	0	\N	\N	459	1	11364
1034	344	0	\N	\N	489	1	12896.5799999999999
1035	344	0	\N	\N	519	1	780
1036	345	0	\N	\N	489	1	283.230000000000018
1037	346	0	\N	\N	428	1	13232
1038	346	0	\N	\N	489	1	12896.5799999999999
1039	346	0	\N	\N	519	1	10830
1042	349	0	\N	\N	519	1	10830
1041	349	0	\N	\N	489	1	12896.5799999999999
1040	349	0	\N	\N	428	1	13232
\.


--
-- TOC entry 2634 (class 0 OID 0)
-- Dependencies: 211
-- Name: order_detail_id_order_detail_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('order_detail_id_order_detail_seq', 1042, true);


--
-- TOC entry 2635 (class 0 OID 0)
-- Dependencies: 212
-- Name: order_id_order_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('order_id_order_seq', 347, true);


--
-- TOC entry 2562 (class 0 OID 24784)
-- Dependencies: 213
-- Data for Name: palette; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY palette (id_palette, denomination, status) FROM stdin;
1	Cons	1
2	Easy-Com	1
3	Sod-Com	1
4	Sod-Pap	1
5	Spal	1
\.


--
-- TOC entry 2636 (class 0 OID 0)
-- Dependencies: 214
-- Name: palette_id_palette_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('palette_id_palette_seq', 5, true);


--
-- TOC entry 2564 (class 0 OID 24789)
-- Dependencies: 215
-- Data for Name: password_resets; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY password_resets (email, token, created_at) FROM stdin;
\.


--
-- TOC entry 2565 (class 0 OID 24795)
-- Dependencies: 216
-- Data for Name: payment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY payment (id_payment, id_order, collection_id, date, transaction_amount, total_paid_amount, shipping_cost, currency_id, status, status_detail, operation_type, date_approved, date_created, last_modified, amount_refunded, preference_id, external_reference, payment_type, merchant_order_id) FROM stdin;
4	349	2213368892	2016-07-28 20:53:19	24954	24954	0	CLP	approved	accredited	regular_payment	2016-07-28 15:37:06	2016-07-28 15:37:06	2016-07-28 15:37:06	0	222658616-883b95a0-90d4-4017-8ff2-66d7f1f44779	orden349	\N	359430551
\.


--
-- TOC entry 2637 (class 0 OID 0)
-- Dependencies: 217
-- Name: payment_id_payment_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('payment_id_payment_seq', 4, true);


--
-- TOC entry 2567 (class 0 OID 24800)
-- Dependencies: 218
-- Data for Name: product_discount; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY product_discount (id_product_discount, id_product, id_discount, created_at, updated_at) FROM stdin;
\.


--
-- TOC entry 2638 (class 0 OID 0)
-- Dependencies: 219
-- Name: product_discount_id_product_discount_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('product_discount_id_product_discount_seq', 1, false);


--
-- TOC entry 2569 (class 0 OID 24805)
-- Dependencies: 220
-- Data for Name: product_offer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY product_offer (id_offer, created_at, updated_at, id_product_offer, id_product) FROM stdin;
2	\N	\N	215	2
1	\N	\N	223	456
\.


--
-- TOC entry 2570 (class 0 OID 24810)
-- Dependencies: 221
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY products (name, description, code, id_color, price, stock, measure, id_category, id_image, created_at, updated_at, material, finish, size, item_box, kg_meter, id_enviroment, price_sample, palette, rank, id_purpose, id_product, id_status) FROM stdin;
LISTEL AQUA 7X35	LISTEL AQUA 7X35	8100011272	2	10437	3927	273	4	\N	\N	\N	ceramica	fino	7X35	7	9	2	1217	2	2	5	542	1
Ali Sira	AliVamos q si se puede	11	1	123	13	123	2	\N	\N	2017-04-11 11:27:42	porcelanato	fino	132	132	123	6	123	\N	\N	2	90	4
rosaly	sira hermana	rosaly	1	123	123	123	7	\N	2017-04-11 13:15:52	2017-04-11 19:48:40	porcelanato	obscuro	132	123	123	6	123	\N	\N	2	100	6
CEMENTO ARENA 60X60 GP	CEMENTO ARENA 60X60 GP	6491188270	1	13013	7365	213	2	210	\N	\N	ceramica	obscuro	60/60	9	8	2	1165	4	1	1	420	7
INSERTO RAMAGE ROUGE 27X45	INSERTO RAMAGE ROUGE 27X45	8100042206	27	13061	12872	208	9	274	\N	\N	porcelanato	obscuro	27X45	8	4	1	821	1	1	5	585	1
INS RAMAGE ROUGE SIN FIN 27X45	INS RAMAGE ROUGE SIN FIN 27X45	8100042214	27	13555	1946	780	9	275	\N	\N	ceramica	fino	27X45	5	7	3	1178	3	1	5	584	1
LISTEL CACEROLAS 7X35	LISTEL CACEROLAS 7X35	8053231048	4	12198	8773	16	4	279	\N	\N	ceramica	claro	7X35	1	8	2	1331	3	2	5	568	1
LISTEL CAZOLETA BEIGE 7X35	LISTEL CAZOLETA BEIGE 7X35	8100011345	4	14539	7847	366	4	280	\N	\N	porcelanato	fino	7X35	7	4	2	79	4	2	5	569	1
LISTEL CHARLOTTE 7X35	LISTEL CHARLOTTE 7X35	8100042382	26	10689	3348	565	4	281	\N	\N	porcelanato	claro	7X35	9	5	3	596	1	2	5	583	1
Rosa	Catalina	1122	10	111	111	111	1	\N	2017-04-11 21:40:27	2017-04-11 21:40:27	porcelanato	obscuro	3333	111	111	1	111	\N	\N	5	110	4
33333333333	3333333	33333333	10	3333333	3333333	3333333	1	\N	2017-04-24 14:01:38	2017-04-24 14:01:38	porcelanato	obscuro	33333	333333	33333	1	3333333	\N	\N	2	1081	4
LISTEL CORRALLI BEIGE 7X35	LISTEL CORRALLI BEIGE 7X35	8100011281	10	12660	14295	580	4	283	\N	\N	porcelanato	fino	7X35	4	9	3	374	1	2	5	593	1
LISTEL FRUTAS 7X35	LISTEL FRUTAS 7X35	8053231056	4	11073	4366	454	4	285	\N	\N	ceramica	obscuro	7X35	4	6	3	409	5	2	5	570	1
LISTEL FRUTILLA BEIGE 7X35	LISTEL FRUTILLA BEIGE 7X35	8100042398	4	10844	7391	50	4	286	\N	\N	porcelanato	claro	7X35	7	8	2	1217	4	2	5	571	1
LISTEL GARRAFA BEIGE 7X35	LISTEL GARRAFA BEIGE 7X35	8100011248	4	12380	8406	36	4	287	\N	\N	ceramica	fino	7X35	8	4	5	896	2	2	5	572	1
4444444444	444444444444	44444444444	10	44444	444444	4444	1	\N	2017-04-24 14:02:59	2017-04-24 14:02:59	porcelanato	obscuro	44444	444444444	444444	1	44444	\N	\N	5	1082	4
LISTEL PETALO GUINDA 7x35	LISTEL PETALO GUINDA 7x35	8053231021	28	10809	2405	364	4	295	\N	\N	porcelanato	claro	7X35	6	2	3	993	3	2	5	589	1
CALIZA BEIGE 45X45	CALIZA BEIGE 45X45	6491237271	4	12364	978	420	1	203	\N	\N	ceramica	fino	45/45	9	10	1	1241	4	1	1	434	1
5555555555	555555555	5555555555555	10	5555	55	555555	8	\N	2017-04-24 14:07:42	2017-04-24 14:07:42	porcelanato	obscuro	5555	5	5	1	55555555	\N	\N	5	1100	4
CONCRETO GRIS SPUL 60X60 GP	CONCRETO GRIS SPUL 60X60 GP	6491175265	15	14633	1855	635	2	75	\N	\N	ceramica	fino	60/60	3	9	3	1435	3	1	1	494	1
FACHALETA BRICK GRIS 34X60	FACHALETA BRICK GRIS 34X60	6491551713	15	11428	6091	427	2	76	\N	\N	porcelanato	obscuro	30/60	3	4	4	160	3	1	2	495	1
LISTEL RAFAELLA BEIGE 7X35	LISTEL RAFAELLA BEIGE 7X35	8100042446	4	13078	7458	357	4	298	\N	\N	porcelanato	obscuro	7X35	10	10	3	45	3	2	5	573	1
LISTEL SAMANTHA ARENA 7X35	LISTEL SAMANTHA ARENA 7X35	8100011230	4	14934	12725	250	4	299	\N	\N	ceramica	claro	7X35	1	1	2	1190	4	2	5	574	1
LISTEL SAMOA NEGRO 7X35	LISTEL SAMOA NEGRO 7X35	8100042294	9	12532	11328	179	4	302	\N	\N	porcelanato	fino	7X35	1	8	3	292	4	2	5	587	1
MALLA M ALERCE (FH-C-018) 30,5X30,5	MALLA M ALERCE (FH-C-018) 30,5X30,5	8100011698	25	13538	11181	103	7	304	\N	\N	porcelanato	obscuro	30,5X30,5	8	8	6	260	3	1	5	579	1
MALLA MAR.METAL(MBC117)30X30	MALLA MAR.METAL(MBC117)30X30	8100041228	10	12446	10506	335	7	306	\N	\N	porcelanato	claro	30X30	9	1	3	1105	4	1	5	595	1
MALLA M.BEIGE(C019 SKS)30,5X30,5	MALLA M.BEIGE(C019 SKS)30,5X30,5	8100041058	4	12278	12512	694	7	307	\N	\N	ceramica	obscuro	30,5X30,5	7	4	6	487	3	1	5	576	1
MALLA M. BIANCO (MBC003) 30X30	MALLA M. BIANCO (MBC003) 30X30	8100041287	4	12938	311	102	7	308	\N	\N	porcelanato	fino	30X30	3	4	2	391	4	1	5	575	1
MALLA M. CAFE(C107 SKS)30X30	MALLA M. CAFE(C107 SKS)30X30	8100041015	25	12409	2472	633	7	309	\N	\N	ceramica	claro	30X30	7	9	5	529	4	1	5	580	1
MALLA M.METABEI(MBC104)30X30	MALLA M.METABEI(MBC104)30X30	8100041201	4	12454	7482	201	7	311	\N	\N	porcelanato	claro	30X30	5	2	3	860	5	1	5	577	1
MALLA M. OPAL (LW001) 30,5X30,5	MALLA M. OPAL (LW001) 30,5X30,5	8100041139	10	14919	2038	475	7	313	\N	\N	ceramica	obscuro	30,5X30,5	3	2	2	192	1	1	5	594	1
MALLA V.HUMO(WH005)30X30	MALLA V.HUMO(WH005)30X30	8100041252	9	10105	9281	90	7	318	\N	\N	ceramica	obscuro	30X30	4	4	5	1019	3	1	5	588	1
FACHALETA HARMONY GRIS 27X45	FACHALETA HARMONY GRIS 27X45	6491554665	15	10861	1188	37	1	78	\N	\N	porcelanato	fino	30/45	3	5	3	82	4	1	2	497	1
7777777777	7777777777	777777777	11	777777	77777777	77777777	8	346	2017-04-24 16:03:48	2017-04-24 20:08:04	porcelanato	obscuro	77777	777777	77777777	1	77777777	\N	\N	2	1121	4
Gaby	Gabrielitita	1234567890123467	32	115.519999999999996	52	111	4	337	\N	2017-04-23 23:34:20	porcelanato	obscuro	3455	1118	1111	6	15.6500000000000004	\N	\N	2	60	3
Alianna Sira	bella y hermosa, cariñosa, bellisima.yes  la amo demasiado	123465678901234567	21	534567	354	3589	4	339	\N	2017-04-24 08:47:25	ceramica	claro	333	354	345	2	3456	\N	\N	2	54	4
666666666	66666666	66666	10	666666	66666666	66666666	8	341	2017-04-24 16:02:15	2017-04-24 16:02:15	porcelanato	claro	66666	6666666	666666666	1	6666666	\N	\N	2	1120	4
CEMENTO MARFIL 60X60 GP	CEMENTO MARFIL 60X60 GP	6491193263	18	10389	7673	62	2	211	\N	\N	porcelanato	obscuro	60/60	6	2	4	1470	5	1	1	513	1
DECO MOTIVES MIX 21.6X21.6	DECO MOTIVES MIX 21.6X21.6	6491050314	9	14906	2688	797	1	213	\N	\N	porcelanato	claro	22/22	9	2	2	958	1	1	3	469	1
MARA TOSTADO 45X45	MARA TOSTADO 45X45	6490156267	6	10631	12544	303	1	36	\N	\N	porcelanato	fino	45/45	6	4	4	1479	2	1	1	455	1
PORTLAND VISÓN 60X60 GP	PORTLAND VISÓN 60X60 GP	6380306263	22	14018	3610	146	2	240	\N	\N	ceramica	fino	60/60	8	10	2	650	1	1	1	530	1
churry	gregory mi hermano	churry	8	1321.55999999999995	312	224	2	342	2016-04-09 23:51:50	2017-04-24 16:03:05	porcelanato	obscuro	623	475	535	2	156	\N	\N	4	91	5
CONCRETO GRIS MATE 60X60 GP	CONCRETO GRIS MATE 60X60 GP	6491174269	15	12920	11476	292	2	74	\N	\N	porcelanato	claro	60/60	2	10	3	1267	2	1	1	493	1
FLECHA JARRON (25F209W) 8X25	FLECHA JARRON (25F209W) 8X25	8100011655	10	11577	13342	381	8	251	\N	\N	porcelanato	obscuro	8X25	9	7	1	938	3	2	5	591	1
GERVASONI BEIGE 60X60 GP	GERVASONI BEIGE 60X60 GP	6490819266	4	13336	2565	153	2	218	\N	\N	ceramica	obscuro	60/60	4	6	3	273	2	1	1	438	1
JAZZ AZUL 36X36	JAZZ AZUL 36X36	6491400714	2	12028	11713	633	1	221	\N	\N	ceramica	claro	36/36	1	6	5	1071	1	1	1	430	1
KELTIC SMOKE 30x60 GP	KELTIC SMOKE 30x60 GP	6380352869	1	11442	4061	482	2	225	\N	\N	porcelanato	fino	30/60	3	4	2	740	2	1	1	425	1
LOFT BEIGE 30x60 GP	LOFT BEIGE 30x60 GP	6380350866	4	13684	685	175	2	228	\N	\N	porcelanato	claro	30/60	4	7	3	391	2	1	1	439	1
LOFT BEIGE 60x60 GP	LOFT BEIGE 60x60 GP	6380300265	4	11168	13058	221	2	229	\N	\N	ceramica	fino	60/60	6	6	6	904	1	1	1	440	1
PORC.SUPER BEIGE NANO 60x60	PORC.SUPER BEIGE NANO 60x60	6380106262	4	11569	5358	316	3	233	\N	\N	ceramica	fino	60/60	3	10	4	10	5	1	4	446	1
OLMO BEIGE 20X120 GP	OLMO BEIGE 20X120 GP	6370202020	4	10302	13966	302	2	236	\N	\N	ceramica	obscuro	Tabla	6	9	5	905	4	1	1	444	1
OLMO MIEL 20X120 GP	OLMO MIEL 20X120 GP	6370200017	5	11380	14100	506	2	237	\N	\N	ceramica	fino	Tabla	9	4	2	1017	4	1	1	452	1
PORC. SPAZIO AZUL 30X60	PORC. SPAZIO AZUL 30X60	6360100863	3	13725	3195	252	3	239	\N	\N	ceramica	obscuro	30/60	2	9	4	339	4	1	4	432	1
TRAVERTINO MATE MARFI 60X60 GP	TRAVERTINO MATE MARFI 60X60 GP	6490813268	4	13602	4121	110	2	242	\N	\N	ceramica	obscuro	60/60	2	9	6	1269	2	1	1	450	1
KELTIC SMOKE 60X60 GP	KELTIC SMOKE 60X60 GP	6380302268	1	14396	2551	490	2	7	\N	\N	ceramica	obscuro	60/60	7	5	2	636	1	1	1	426	1
PEHUEN CORTE BLANCO 45X45	PEHUEN CORTE BLANCO 45X45	6491213262	1	11075	5606	550	1	8	\N	\N	porcelanato	claro	45/45	8	4	6	323	3	1	1	427	1
AGADIR AZUL 45X45	AGADIR AZUL 45X45	6491016264	2	13232	13678	514	1	9	\N	\N	ceramica	fino	45/45	3	10	5	1227	2	1	1	428	1
FLOWER BLUE 45X45	FLOWER BLUE 45X45	6491002298	2	10867	6998	587	1	10	\N	\N	porcelanato	obscuro	45/45	2	8	6	864	5	1	1	429	1
SKY BLUE 45X45	SKY BLUE 45X45	6491006293	2	14974	2534	466	1	12	\N	\N	porcelanato	fino	45/45	6	8	3	1351	4	1	1	431	1
FACHALETA BARLETT NATUR 34X60	FACHALETA BARLETT NATUR 34X60	6491550716	4	12612	2917	356	2	16	\N	\N	porcelanato	obscuro	30/60	8	4	1	1305	2	1	2	435	1
FACHALETA FOLLIE NATURAL 34X60	FACHALETA FOLLIE NATURAL 34X60	6491552719	4	11409	7170	654	2	17	\N	\N	ceramica	claro	30/60	3	3	3	1345	3	1	2	436	1
FACHALETA ROMANCE BEIGE 27X45	FACHALETA ROMANCE BEIGE 27X45	6491550670	4	10676	14843	404	1	18	\N	\N	porcelanato	fino	30/45	2	6	2	1056	3	1	2	437	1
MAISON BEIGE 20X120 GP	MAISON BEIGE 20X120 GP	6370403013	4	11643	696	428	2	22	\N	\N	porcelanato	obscuro	Tabla	1	5	3	17	3	1	1	441	1
MARA CLARA 45X45	MARA CLARA 45X45	6490150269	4	14492	11050	138	1	23	\N	\N	ceramica	claro	45/45	4	7	4	574	4	1	1	442	1
NADOR BEIGE 45X45	NADOR BEIGE 45X45	6491006269	4	14947	4350	16	1	24	\N	\N	porcelanato	fino	45/45	5	4	5	1446	4	1	1	443	1
PIEDRA RIO BEIGE 45X45	PIEDRA RIO BEIGE 45X45	6491227265	4	11490	4772	762	1	26	\N	\N	porcelanato	claro	45/45	5	7	6	892	5	1	1	445	1
TRAVERTINO 36X36	TRAVERTINO 36X36	6490823719	4	12817	13550	116	1	29	\N	\N	ceramica	claro	36/36	3	9	2	30	2	1	1	448	1
TRAVERTINO 45X45	TRAVERTINO 45X45	6490815271	4	11841	14899	715	1	30	\N	\N	porcelanato	fino	45/45	6	9	2	1278	4	1	1	449	1
PRAGA BEIGE 60X60 GP	PRAGA BEIGE 60X60 GP	6490822267	5	14799	689	93	2	34	\N	\N	porcelanato	obscuro	60/60	1	3	5	303	3	1	1	453	1
FACHALETA HARMONY BEIGE 27X45	FACHALETA HARMONY BEIGE 27X45	6491553669	6	14186	7057	442	1	35	\N	\N	ceramica	claro	30/45	5	9	4	275	2	1	2	454	1
BUD ARENA 60X60 GP	BUD ARENA 60X60 GP	6490824270	4	13065	3257	226	2	197	\N	\N	porcelanato	claro	60/60	10	6	3	742	2	1	1	433	1
CASTAÑO MIX 45X45	CASTAÑO MIX 45X45	6490165266	5	13230	9959	286	1	209	\N	\N	porcelanato	claro	45/45	6	6	3	457	5	1	1	451	1
BLANCO BRILLANTE 34X60	BLANCO BRILLANTE 34X60	6490950721	7	10999	7911	109	2	37	\N	\N	ceramica	obscuro	30/60	9	9	5	1298	2	1	2	456	1
LISO BLANCO 36X36	LISO BLANCO 36X36	6490901720	7	12696	1660	130	1	43	\N	\N	ceramica	obscuro	36/36	3	8	2	634	2	1	1	462	1
NACAR BLANCO 45X45	NACAR BLANCO 45X45	6491228262	7	14672	7569	44	1	44	\N	\N	porcelanato	claro	45/45	4	5	4	911	4	1	1	463	1
QATAR BLANCO 34X60	QATAR BLANCO 34X60	6491051720	7	10542	4512	301	2	45	\N	\N	ceramica	fino	30/60	7	9	1	146	4	1	2	464	1
MOSAIK DUO 45X45	MOSAIK DUO 45X45	6491222263	8	14484	431	332	1	46	\N	\N	porcelanato	obscuro	45/45	6	9	5	270	5	1	1	465	1
CUADROS NEGRO 36X36	CUADROS NEGRO 36X36	6491016720	9	12922	4689	327	1	47	\N	\N	ceramica	claro	36/36	7	7	5	277	5	1	1	466	1
CUADROS NEGRO 45X45	CUADROS NEGRO 45X45	6491012269	9	12012	8134	131	1	48	\N	\N	porcelanato	fino	45/45	3	9	3	1234	1	1	1	467	1
CUBO NEGRO 45X45	CUBO NEGRO 45X45	6491013265	9	13134	11610	553	1	49	\N	\N	ceramica	obscuro	45/45	3	5	2	674	4	1	1	468	1
FLOR NEGRO 36X36	FLOR NEGRO 36X36	6491017716	9	12091	6225	768	1	51	\N	\N	ceramica	fino	36/36	3	8	4	1239	2	1	1	470	1
FACHALETA SPA COGNAC 34X60	FACHALETA SPA COGNAC 34X60	6491554712	10	11681	13969	374	2	52	\N	\N	porcelanato	obscuro	30/60	4	2	5	1489	3	1	2	471	1
FRESNO AMERICANO 45X45	FRESNO AMERICANO 45X45	6490149271	10	13488	14991	485	1	53	\N	\N	ceramica	claro	45/45	4	8	4	456	1	1	1	472	1
KELTIC BROWN 60X60 GP	KELTIC BROWN 60X60 GP	6380304271	10	11116	8464	470	2	55	\N	\N	ceramica	obscuro	60/60	9	1	5	221	2	1	1	474	1
PARQUET CEDRO 45X45	PARQUET CEDRO 45X45	6490137263	10	12535	4056	148	1	56	\N	\N	porcelanato	claro	45/45	2	9	6	1283	1	1	1	475	1
OXIDUM CUPRICO 60X60 GP	OXIDUM CUPRICO 60X60 GP	6491199262	11	14616	2700	44	2	59	\N	\N	ceramica	claro	60/60	7	6	4	494	2	1	1	478	1
PARQUET CEDRO OSCURO 45X45	PARQUET CEDRO OSCURO 45X45	6490138269	11	10457	740	289	1	60	\N	\N	porcelanato	fino	45/45	4	7	4	67	3	1	1	479	1
TARIMA NEGRO 20X120 GP	TARIMA NEGRO 20X120 GP	6370400013	11	11681	12007	521	2	61	\N	\N	ceramica	obscuro	Tabla	7	3	4	1097	2	1	1	480	1
ZAGORA AZUL 45X45	ZAGORA AZUL 45X45	6491008262	12	14871	12473	439	1	62	\N	\N	porcelanato	claro	45/45	7	5	6	171	2	1	1	481	1
MOSAIK COLOR 45X45	MOSAIK COLOR 45X45	6491221267	13	12238	6267	680	1	64	\N	\N	porcelanato	obscuro	45/45	5	8	4	1096	4	1	1	483	1
PIEDRA RIO COLOR 45X45	PIEDRA RIO COLOR 45X45	6491226269	13	12872	13586	533	1	65	\N	\N	ceramica	claro	45/45	7	6	4	606	1	1	1	484	1
CEMENTO GRAFITO 60X60 GP	CEMENTO GRAFITO 60X60 GP	6491190264	14	14233	3694	469	2	66	\N	\N	porcelanato	fino	60/60	9	5	6	140	3	1	1	485	1
IBERICA OXIDO 45X45	IBERICA OXIDO 45X45	6491105265	14	12088	786	552	1	67	\N	\N	ceramica	obscuro	45/45	9	9	5	833	5	1	1	486	1
NACAR GRAFITO 45X45	NACAR GRAFITO 45X45	6491229268	14	10063	7251	529	1	68	\N	\N	porcelanato	claro	45/45	1	9	1	262	3	1	1	487	1
PIEDRA RIO GRIS 45X45	PIEDRA RIO GRIS 45X45	6491225263	14	12993	12099	262	1	69	\N	\N	ceramica	fino	45/45	3	6	3	593	1	1	1	488	1
BUD GRIS 60X60 GP	BUD GRIS 60X60 GP	6490825266	15	13304	12284	753	2	71	\N	\N	ceramica	claro	60/60	2	9	5	609	4	1	1	490	1
GLOSS WHITE 34X60	GLOSS WHITE 34X60	6491050713	7	11810	7835	372	2	219	\N	\N	ceramica	claro	30/60	5	9	4	526	3	1	2	460	1
JAZZ BLANCO 36X36	JAZZ BLANCO 36X36	6491401721	7	10285	8954	29	1	222	\N	\N	porcelanato	fino	36/36	7	5	2	378	5	1	1	461	1
KELTIC BROWN 30x60 GP	KELTIC BROWN 30x60 GP	6380354862	10	10267	14470	467	2	223	\N	\N	porcelanato	fino	30/60	4	6	6	755	2	1	1	473	1
LENGA NATIVA 45X45	LENGA NATIVA 45X45	6490148264	11	13998	6738	273	1	226	\N	\N	ceramica	fino	45/45	10	3	5	498	2	1	1	476	1
MIX COLOR 60x60	MIX COLOR 60x60	6491020262	13	10364	12915	416	1	234	\N	\N	ceramica	fino	60/60	5	8	1	90	1	1	1	482	1
OLMO NEGRO 20X120 GP	OLMO NEGRO 20X120 GP	6370401013	11	14974	8341	619	2	238	\N	\N	porcelanato	obscuro	Tabla	3	3	5	724	4	1	1	477	1
ABEDUL CENIZA 45X45	ABEDUL CENIZA 45X45	6490154264	15	12896.5799999999999	6475	119	8	70	\N	\N	porcelanato	obscuro	45/45	6	8	4	283.230000000000018	4	1	1	489	1
CIMENTA CENIZA 45X45	CIMENTA CENIZA 45X45	6491178264	15	11674	7257	204	1	72	\N	\N	porcelanato	fino	45/45	7	4	4	415	2	1	1	491	1
BLANCO SATINADO 34X60	BLANCO SATINADO 34X60	6490951717	7	11364	1187	177	2	193	\N	\N	porcelanato	obscuro	30/60	2	10	3	1496	4	1	2	459	1
BLANCO SATIN RECT. 30X60 (MV)	BLANCO SATIN RECT. 30X60 (MV)	6380251868	7	14572	8477	269	1	194	\N	\N	ceramica	fino	30/60	6	4	2	1149	4	1	2	458	1
SOHO BEIGE 34X60	SOHO BEIGE 34X60	6491650721	4	13788	8095	451	2	28	\N	\N	porcelanato	obscuro	30/60	3	9	5	201	2	1	2	447	1
FACHALETA ROMANCE GRIS 27X45	FACHALETA ROMANCE GRIS 27X45	6491551666	15	10658	341	77	1	79	\N	\N	ceramica	obscuro	30/45	9	8	3	540	2	1	2	498	1
FEZ GRIS 45X45	FEZ GRIS 45X45	6491007265	15	13292	11251	80	1	80	\N	\N	porcelanato	claro	45/45	4	6	4	1248	4	1	1	499	1
KELTIC GREY 60X60 GP 	KELTIC GREY 60X60 GP 	6380303264	15	12675	11821	524	2	84	\N	\N	porcelanato	fino	60/60	4	9	2	1409	1	1	1	503	1
MAISON GRIS 20X120 GP	MAISON GRIS 20X120 GP	6370402013	15	14321	14025	456	2	85	\N	\N	ceramica	obscuro	Tabla	8	9	1	347	4	1	1	504	1
PORTLAND GREY 30X60 GP	PORTLAND GREY 30X60 GP	6380357871	15	11140	10336	724	2	87	\N	\N	ceramica	fino	30/60	10	8	3	1328	4	1	1	506	1
PORTLAND GREY 60X60 GP	PORTLAND GREY 60X60 GP	6380307270	15	13993	6228	632	2	88	\N	\N	porcelanato	obscuro	60/60	9	5	5	976	1	1	1	507	1
REZATTO GRIS 45X45	REZATTO GRIS 45X45	6491211260	15	14356	12588	157	1	89	\N	\N	ceramica	claro	45/45	6	6	3	1486	4	1	1	508	1
SKY GREY 45X45	SKY GREY 45X45	6491008296	15	13531	14079	377	1	90	\N	\N	porcelanato	fino	45/45	7	4	3	489	4	1	1	509	1
TECA PINTADO 45X45	TECA PINTADO 45X45	6490153268	15	14789	7681	664	1	91	\N	\N	ceramica	obscuro	45/45	3	9	3	136	2	1	1	510	1
CEMENTO HABANO 60X60 GP	CEMENTO HABANO 60X60 GP	6491192267	17	10392	13461	468	2	93	\N	\N	ceramica	fino	60/60	3	4	5	1481	4	1	1	512	1
PORC.SUPER  WHITE 60x60	PORC.SUPER  WHITE 60x60	6380122270	18	10680	7221	787	3	97	\N	\N	ceramica	obscuro	60/60	5	4	2	1312	3	1	4	516	1
PORTLAND IVORY 60X60 GP	PORTLAND IVORY 60X60 GP	6380305267	18	10056	5320	318	2	99	\N	\N	ceramica	fino	60/60	4	8	3	779	4	1	1	518	1
ALELI MARRON 45X45	ALELI MARRON 45X45	6491233265	19	10830	6882	380	1	100	\N	\N	porcelanato	obscuro	45/45	3	10	3	780	3	1	1	519	1
FACHALETA LAJA ZEN 27X45	FACHALETA LAJA ZEN 27X45	6491552663	19	11365	2116	232	1	102	\N	\N	porcelanato	fino	30/45	1	2	5	654	3	1	2	521	1
FACHALETA LUAU NATURAL 34X60	FACHALETA LUAU NATURAL 34X60	6491553715	19	10474	5836	480	2	103	\N	\N	ceramica	obscuro	30/60	9	3	6	597	2	1	2	522	1
OLMO RUSTICO 20X120 GP	OLMO RUSTICO 20X120 GP	6370406013	19	13379	5273	119	2	105	\N	\N	ceramica	fino	Tabla	4	6	3	911	1	1	1	524	1
CONCEPT OUT BLACK 60X60 GP	CONCEPT OUT BLACK 60X60 GP	6491103264	20	10159	7196	174	2	106	\N	\N	porcelanato	obscuro	60/60	4	7	3	271	2	1	1	525	1
PORC.SUPER BLACK  NANO 60x60	PORC.SUPER BLACK  NANO 60x60	6380121263	20	13026	13316	208	3	108	\N	\N	porcelanato	fino	60/60	4	3	3	277	4	1	4	527	1
CONCEPT OUT GRIS 60X60 GP	CONCEPT OUT GRIS 60X60 GP	6491102268	15	13209	14816	703	2	212	\N	\N	ceramica	obscuro	60/60	7	3	3	7	5	1	1	492	1
FACHALETA FANTASY WHITE 27X45	FACHALETA FANTASY WHITE 27X45	6491555662	15	10431	5612	98	1	214	\N	\N	ceramica	claro	30/45	8	3	3	695	5	1	2	496	1
FACHALETA TENTACION 27X45	FACHALETA TENTACION 27X45	6491556668	19	12977	10333	45	1	215	\N	\N	porcelanato	claro	30/45	2	3	6	656	4	1	2	523	1
FLOR GRIS 45X45	FLOR GRIS 45X45	6491017271	15	12112	3217	493	1	217	\N	\N	ceramica	fino	45/45	6	4	4	791	3	1	1	500	1
GRANITO GRIS SMARTILE 59X59	GRANITO GRIS SMARTILE 59X59	6491302267	15	13487	11108	469	2	220	\N	\N	porcelanato	obscuro	60/60	6	10	1	1041	4	1	1	501	1
KELTIC GREY 30x60 GP	KELTIC GREY 30x60 GP	6380353865	15	11685	7046	790	2	224	\N	\N	ceramica	claro	30/60	8	8	3	1436	5	1	1	502	1
LISO NEGRO 36X36	LISO NEGRO 36X36	6490902716	20	14903	2700	659	1	227	\N	\N	ceramica	claro	36/36	1	6	3	1499	2	1	1	526	1
LOFT IVORY 30x60 GP	LOFT IVORY 30x60 GP	6380351863	18	12441	7731	173	2	230	\N	\N	ceramica	claro	30/60	6	2	5	1099	5	1	1	514	1
LOFT IVORY 60x60 GP	LOFT IVORY 60x60 GP	6380301262	18	13373	12866	264	2	231	\N	\N	porcelanato	fino	60/60	4	9	4	740	3	1	1	515	1
PORTLAND IVORY 30X60 GP	PORTLAND IVORY 30X60 GP	6380355868	18	10035	5593	771	2	232	\N	\N	porcelanato	claro	30/60	9	7	4	388	3	1	1	517	1
SOFT COLOR 27X45	SOFT COLOR 27X45	6491050667	16	11937	1718	587	1	241	\N	\N	porcelanato	claro	30/45	4	6	4	395	2	1	2	511	1
GARDEN GREEN 45X45	GARDEN GREEN 45X45	6491004301	21	11912	9966	764	1	109	\N	\N	ceramica	obscuro	45/45	8	4	1	884	1	1	1	528	1
PORTLAND VISON 30X60 GP	PORTLAND VISON 30X60 GP	6380356864	22	13417	6333	387	2	110	\N	\N	porcelanato	claro	30/60	4	8	4	1071	3	1	1	529	1
FLECHA LIRIO AZUL (DK103A) 8X25	FLECHA LIRIO AZUL (DK103A) 8X25	8100011493	2	14100	9266	207	8	249	\N	\N	porcelanato	fino	8X25	3	5	5	724	2	2	5	539	1
FLECHA JARRON AZUL (DKJ518D)  8X25	FLECHA JARRON AZUL (DKJ518D)  8X25	8100012058	2	10973	6771	366	8	250	\N	\N	ceramica	claro	8X25	1	2	5	836	2	2	5	538	1
FLECHA RAMAS 8X25	FLECHA RAMAS 8X25	8100042486	2	13787	5924	275	8	252	\N	\N	ceramica	obscuro	8X25	9	8	2	333	2	2	5	540	1
FLECHA ROMBO AZUL (25F142W) 8X25	FLECHA ROMBO AZUL (25F142W) 8X25	8100011639	2	10965	8459	481	8	253	\N	\N	porcelanato	claro	8X25	5	2	1	369	5	2	5	541	1
FLECHA CALA 8X25	FLECHA CALA 8X25	8100042478	2	14116	3275	766	8	254	\N	\N	ceramica	fino	8X25	10	3	5	245	2	2	5	536	1
FLECHA DELFIN (DKJ1620) 8X25	FLECHA DELFIN (DKJ1620) 8X25	8100012066	2	14936	10740	584	8	255	\N	\N	porcelanato	obscuro	8X25	1	7	2	46	1	2	5	537	1
FLECHA CAMPESTRE (DKJ224A) 8X25	FLECHA CAMPESTRE (DKJ224A) 8X25	8100012040	4	12326	2057	221	8	256	\N	\N	ceramica	claro	8X25	7	5	2	1018	3	2	5	556	1
FLECHA CHEF 8X25	FLECHA CHEF 8X25	8100042502	24	13056	4365	102	8	257	\N	\N	porcelanato	fino	8X25	6	5	5	1223	4	2	5	533	1
FLECHA CIELO (DK309D) 8X25	FLECHA CIELO (DK309D) 8X25	8100011566	4	10279	8703	444	8	258	\N	\N	porcelanato	fino	8X25	6	9	5	1150	3	2	5	557	1
FLECHA COCINA (DKJ1177B) 8X25	FLECHA COCINA (DKJ1177B) 8X25	8100012031	4	10419	9215	598	8	259	\N	\N	ceramica	obscuro	8X25	1	3	5	1416	3	2	5	558	1
FLECHA MOSAICO 8X25	FLECHA MOSAICO 8X25	8100042470	23	14426	7060	99	8	262	\N	\N	porcelanato	obscuro	8X25	4	4	6	540	2	2	5	555	1
FLECHA ORIENTAL (25F122W) 8X25	FLECHA ORIENTAL (25F122W) 8X25	8100011621	4	13740	10649	453	8	263	\N	\N	porcelanato	claro	8X25	10	3	2	789	2	2	5	559	1
FLECHA OTOÑO (DKJ211A) 8X25	FLECHA OTOÑO (DKJ211A) 8X25	8100011582	4	12374	3443	571	8	265	\N	\N	ceramica	fino	8X25	4	6	4	443	2	2	5	560	1
FLECHA PLATO (25F278W) 8X25	FLECHA PLATO (25F278W) 8X25	8100011671	4	10275	2585	321	8	266	\N	\N	porcelanato	obscuro	8X25	6	8	6	284	4	2	5	561	1
FLECHA ROSA (DKJ308) 8X25	FLECHA ROSA (DKJ308) 8X25	8100011604	4	14990	5371	579	8	268	\N	\N	ceramica	claro	8X25	4	9	6	486	5	2	5	562	1
FLECHA TABLA 8X25	FLECHA TABLA 8X25	8100042494	4	10494	549	539	8	269	\N	\N	porcelanato	fino	8X25	3	3	4	556	4	2	5	563	1
LISTEL AQUAMARINA 14.5X26	LISTEL AQUAMARINA 14.5X26	8100042550	2	11758	9233	163	4	278	\N	\N	porcelanato	obscuro	14,5X26	2	4	5	209	3	2	5	543	1
LISTEL CITRIQUE 7X35	LISTEL CITRIQUE 7X35	8100042390	23	14184	6592	447	4	282	\N	\N	porcelanato	obscuro	7X35	7	1	1	1221	4	2	5	531	1
LISTEL FEZ PISCINA 14.5x26	LISTEL FEZ PISCINA 14.5x26	8100042454	2	10929	1220	788	4	284	\N	\N	ceramica	claro	14,5X26	3	1	3	367	4	2	5	544	1
LISTEL LEMONS 7X35	LISTEL LEMONS 7X35	8100042406	23	13741	1010	367	4	288	\N	\N	ceramica	claro	7X35	2	5	3	50	3	2	5	532	1
LISTEL LONDON ARENA 7X35	LISTEL LONDON ARENA 7X35	8100011221	1	13714	10517	481	4	289	\N	\N	ceramica	obscuro	7X35	5	5	2	483	2	2	5	534	1
CUOMO BLANCO 36X36	CUOMO BLANCO 36X36	6491132718	1	10476	1721	601	1	2	\N	\N	porcelanato	claro	36/36	9	4	5	1389	4	1	1	421	8
CUOMO BLANCO 45X45	CUOMO BLANCO 45X45	6491133269	1	11056	11525	95	1	3	\N	\N	ceramica	fino	45/45	2	6	4	786	4	1	1	422	2
HAYA ARENA 45X45	HAYA ARENA 45X45	6490157263	1	13084	13345	196	1	4	\N	\N	porcelanato	obscuro	45/45	6	9	5	1459	4	1	1	423	3
ITACA 60X60 GP	ITACA 60X60 GP	6490820264	1	11423	4076	684	2	5	\N	\N	ceramica	claro	60/60	7	6	3	570	1	1	1	424	4
MIX GREY 20X60	MIX GREY 20X60	6491000864	15	14341	7486	223	2	235	\N	\N	porcelanato	claro	20/60	1	5	2	847	4	1	2	505	1
FLECHA PIÑA (25F193W) 8X25	FLECHA PIÑA (25F193W) 8X25	8100011647	10	14836	4603	259	8	173	\N	\N	ceramica	claro	8X25	3	5	5	972	2	2	5	592	1
FLECHA DALI (DKJ306) 8X25	FLECHA DALI (DKJ306) 8X25	8100011591	24	10649	10416	126	8	260	\N	\N	ceramica	fino	8X25	7	3	5	672	1	2	5	578	1
FLECHA PRIMAVERA 8X25	FLECHA PRIMAVERA 8X25	8100042518	12	12507	5980	104	8	267	\N	\N	ceramica	claro	8X25	4	7	2	524	3	2	5	598	1
FLECHA TETERA (25F102W) 8X25	FLECHA TETERA (25F102W) 8X25	8100011612	4	11721	8070	498	8	270	\N	\N	ceramica	obscuro	8X25	3	2	4	635	4	2	5	564	1
FLECHA VASIJA (DKJ151) 8X25	FLECHA VASIJA (DKJ151) 8X25	8100011574	4	10031	12733	70	8	271	\N	\N	porcelanato	claro	8X25	5	7	3	502	5	2	5	565	1
INSERTO CUBICA MARFIL 36X36	INSERTO CUBICA MARFIL 36X36	8100042166	4	11110	6385	264	9	272	\N	\N	porcelanato	obscuro	36X36	6	2	2	204	4	1	5	567	1
LISTEL MOSAIK PISCINA 14.5X26	LISTEL MOSAIK PISCINA 14.5X26	8100042534	2	11814	12984	452	4	290	\N	\N	porcelanato	fino	14,5X26	5	3	1	664	4	2	5	545	1
LISTEL OCEAN 14.5X26	LISTEL OCEAN 14.5X26	8100042566	2	13226	1333	43	4	291	\N	\N	ceramica	obscuro	14,5X26	9	6	1	718	2	2	5	546	1
LISTEL OLAS 14.5X26	LISTEL OLAS 14.5X26	8100042558	2	11515	4637	630	4	292	\N	\N	porcelanato	claro	14,5X26	6	5	5	198	1	2	5	547	1
LISTEL PETALO AZUL 7X35	LISTEL PETALO AZUL 7X35	8100011256	2	12523	2487	488	4	294	\N	\N	ceramica	fino	7X35	9	9	3	393	2	2	5	548	1
LISTEL PISCIS 14.5X26	LISTEL PISCIS 14.5X26	8100011990	2	11431	8879	572	4	297	\N	\N	porcelanato	obscuro	14,5X26	3	4	3	285	2	2	5	549	1
LISTEL SAMOA AZUL 7X35	LISTEL SAMOA AZUL 7X35	8100042278	2	10089	11828	415	4	301	\N	\N	porcelanato	fino	7X35	7	5	2	387	2	2	5	551	1
LISTEL POSEIDON 14.5X26	LISTEL POSEIDON 14.5X26	8100042542	2	10308	12579	695	4	303	\N	\N	ceramica	claro	14,5X26	9	3	2	749	3	2	5	550	1
MALLA M.CREMA(C077 SKS)30,5X30,5	MALLA M.CREMA(C077 SKS)30,5X30,5	8100041031	1	12595	3983	655	7	310	\N	\N	porcelanato	claro	30X,5X30,5	3	9	6	1414	2	1	5	535	1
MALLA M.METAZUL (MBC105)30X30	MALLA M.METAZUL (MBC105)30X30	8100041210	2	11230	10676	736	7	312	\N	\N	ceramica	obscuro	30X30	10	10	6	967	3	1	5	552	1
MALLA V ARMONIA (HFDS-J-347) 30X30	MALLA V ARMONIA (HFDS-J-347) 30X30	8100011752	2	12928	399	55	7	315	\N	\N	porcelanato	claro	30X30	3	3	5	236	2	1	5	553	1
MALLA V.COBALTO(SP177)30X30	MALLA V.COBALTO(SP177)30X30	8100041244	2	14953	8525	671	7	316	\N	\N	ceramica	fino	30X30	6	6	5	1072	4	1	5	554	1
INSERT MOZAIK BEIGE METAL36X36	INSERT MOZAIK BEIGE METAL36X36	8100042102	4	13662	9566	678	9	147	\N	\N	ceramica	fino	36X36	1	1	4	580	4	1	5	566	1
MOSAICO M CAFE Y BEIGE (H010)	MOSAICO M CAFE Y BEIGE (H010)	8100012244	25	12426	8175	767	7	162	\N	\N	porcelanato	fino	30X30	4	8	6	435	2	1	5	581	1
INSERTO MOZAIK NEGRO 36X36	INSERTO MOZAIK NEGRO 36X36	8100042142	9	11972	13743	171	9	167	\N	\N	ceramica	claro	36X36	7	4	4	1432	4	1	5	586	1
1111111111	111111111	111111111	10	11111111	11111111	1111111111	1	\N	2017-04-24 13:49:43	2017-04-24 13:49:43	porcelanato	obscuro	111111	1111111111	111111111	1	1111111	\N	\N	5	1060	4
FLECHA COFFE 8X25	FLECHA COFFE 8X25	8100042510	10	14542	4624	658	8	171	\N	\N	ceramica	fino	8X25	10	7	5	925	4	2	5	590	1
MALLA V. MOCCA (GSD232) 30,5X30,5	MALLA V. MOCCA (GSD232) 30,5X30,5	8100041066	10	14104	29	541	7	320	\N	\N	porcelanato	obscuro	30,5X30,5	1	2	5	940	2	1	5	597	1
MALLA V ROBLE (GD-4-23-W601) 30X30	MALLA V ROBLE (GD-4-23-W601) 30X30	8100011710	10	12007	3061	226	7	322	\N	\N	ceramica	fino	30X30	6	2	2	1019	3	1	5	596	1
MOSAICO VM SEPIA (NO-182) 30,5	MOSAICO VM SEPIA (NO-182) 30,5	8100012171	25	11863	6662	370	7	323	\N	\N	ceramica	obscuro	30,5X30,5	2	4	4	562	3	1	5	582	1
BLANCO BRILLANTE RECT 30X60 (5	BLANCO BRILLANTE RECT 30X60 (5	6380250860	7	12387	585	284	1	192	\N	\N	porcelanato	claro	30/60	3	5	2	612	2	1	2	457	1
BUD OXIDO 60X60 GP	BUD OXIDO 60X60 GP	6490810269	19	11675	12966	152	2	198	\N	\N	ceramica	claro	60/60	3	4	2	1130	3	1	1	520	1
FLECHA LIRIO VERDE (DK103B) 8X25	FLECHA LIRIO VERDE (DK103B) 8X25	8100011507	21	10939	14669	785	8	261	\N	\N	ceramica	obscuro	8X25	7	3	4	746	4	2	5	606	1
INSERTO POPPY ROSSO 27X45	INSERTO POPPY ROSSO 27X45	8100042238	30	12391	12416	348	9	273	\N	\N	porcelanato	fino	27X45	9	5	3	1396	2	1	5	605	1
LISTEL ALMIBAR 7X35	LISTEL ALMIBAR 7X35	8100042038	29	10432	13734	704	4	276	\N	\N	porcelanato	claro	7X35	5	6	6	1149	4	2	5	601	1
LISTEL ORANGES 7X35	LISTEL ORANGES 7X35	8100042414	29	13054	9680	312	4	293	\N	\N	ceramica	fino	7X35	10	10	6	586	3	2	5	602	1
LISTEL PETALO VERDE 7X35	LISTEL PETALO VERDE 7X35	8053231030	21	10496	5321	229	4	296	\N	\N	porcelanato	claro	7X35	4	5	4	613	2	2	5	607	1
LISTEL SAMOA 7X35	LISTEL SAMOA 7X35	8100042310	19	13325	768	443	4	300	\N	\N	ceramica	obscuro	7X35	3	8	4	349	5	2	5	600	1
MALLA C BLACK (HJ 0002) 30X30	MALLA C BLACK (HJ 0002) 30X30	8100041121	20	10972	8543	140	7	305	\N	\N	ceramica	claro	30X30	4	5	5	1439	2	1	5	604	1
MALLA V.ALGA(GSD231)30X30	MALLA V.ALGA(GSD231)30X30	8100041074	31	13643	2620	743	7	314	\N	\N	porcelanato	obscuro	30X30	1	2	1	1124	4	1	5	609	1
MALLA V ESPERANZA (GD-4-23-ESO5M) 30X30	MALLA V ESPERANZA (GD-4-23-ESO5M) 30X30	8100011701	21	13659	10928	583	7	317	\N	\N	ceramica	fino	30X30	10	4	5	1090	5	1	5	608	1
MALLA V MARENGO (LY-8FX4804) 29,8X29,8	MALLA V MARENGO (LY-8FX4804) 29,8X29,8	8100011680	15	13752	1786	22	7	319	\N	\N	porcelanato	fino	29,8X29,8	7	5	1	138	4	1	5	599	1
MALLA V.NARANJO(KI 503)30X30	MALLA V.NARANJO(KI 503)30X30	8100041279	29	13817	10342	288	7	321	\N	\N	porcelanato	obscuro	30X30	3	6	1	432	3	1	5	603	1
22222222	22222222	222222	10	222222	22222222	22222222	8	\N	2017-04-24 13:52:26	2017-04-24 13:54:53	porcelanato	obscuro	2222222	22222222	222222	1	2222222	\N	\N	5	1080	4
\.


--
-- TOC entry 2571 (class 0 OID 24818)
-- Dependencies: 222
-- Data for Name: purchase; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY purchase (id_purchase, id_order, id_payment, id_ship_info, date, created_at, updated_at, status) FROM stdin;
\.


--
-- TOC entry 2639 (class 0 OID 0)
-- Dependencies: 223
-- Name: purchase_id_purchase_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('purchase_id_purchase_seq', 29, true);


--
-- TOC entry 2573 (class 0 OID 24823)
-- Dependencies: 224
-- Data for Name: purpose; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY purpose (id_purpose, denomination, status) FROM stdin;
1	Piso	1
2	Muro	1
3	Piso/Comp	1
4	Por	1
5	Com	1
\.


--
-- TOC entry 2640 (class 0 OID 0)
-- Dependencies: 225
-- Name: purpose_id_purpose_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('purpose_id_purpose_seq', 4, true);


--
-- TOC entry 2575 (class 0 OID 24828)
-- Dependencies: 226
-- Data for Name: rank; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY rank (id_rank, denomination, status) FROM stdin;
1	Alto	1
2	Medio	1
3	Bajo	1
\.


--
-- TOC entry 2641 (class 0 OID 0)
-- Dependencies: 227
-- Name: rank_id_rank_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('rank_id_rank_seq', 3, true);


--
-- TOC entry 2577 (class 0 OID 24833)
-- Dependencies: 228
-- Data for Name: relationated_product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY relationated_product (created_at, updated_at, id_relationated_product, id_product, id_product_relation) FROM stdin;
\N	\N	880	54	110
\N	\N	881	54	90
\N	\N	882	54	578
\N	\N	883	54	54
\N	\N	884	54	434
\N	\N	1070	1060	90
\N	\N	1091	1080	90
\N	\N	1092	1080	54
\N	\N	212	420	421
\N	\N	213	420	422
\N	\N	1093	1081	90
\N	\N	1094	1081	434
\N	\N	1095	1082	54
\N	\N	1096	1082	434
\N	\N	1097	1082	451
\N	\N	1098	1082	472
\N	\N	1099	1082	486
\N	\N	1110	1100	578
\N	\N	1111	1100	434
\N	\N	1130	1121	562
\N	\N	1131	1121	110
\N	\N	1132	1121	100
\.


--
-- TOC entry 2578 (class 0 OID 24838)
-- Dependencies: 229
-- Data for Name: ship_info; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ship_info (id_ship_info, date, id_user, city, address, postal_code, created_at, updated_at, id_country, id_district) FROM stdin;
1	2016-07-18 18:24:35	1	caracas	santiago	\N	2016-07-18 18:24:35	2016-07-18 18:24:35	1	4
20	2016-07-22 18:50:49	66	caracas	ff	\N	2016-07-22 18:50:49	2016-07-22 18:50:49	1	3
0	2016-07-18 18:24:35	1	Retiro en Tienda	Retiro en Tienda	\N	2016-07-18 18:24:35	2016-07-18 18:24:35	1	1
\.


--
-- TOC entry 2642 (class 0 OID 0)
-- Dependencies: 230
-- Name: ship_info_id_ship_info_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ship_info_id_ship_info_seq', 20, true);


--
-- TOC entry 2580 (class 0 OID 24846)
-- Dependencies: 231
-- Data for Name: status; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY status (id_status, denomination, table_, shortcut) FROM stdin;
1	Habilitado	generic	hab
2	Deshabilitado	generic	des
3	Procesando	order	pro
4	Aceptado	order	acep
5	En espera de disponibilidad	order	nodis
6	En despacho	order	despa
7	Entregado	order	entre
\.


--
-- TOC entry 2643 (class 0 OID 0)
-- Dependencies: 232
-- Name: status_idStatus_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"status_idStatus_seq"', 2, true);


--
-- TOC entry 2582 (class 0 OID 24854)
-- Dependencies: 233
-- Data for Name: store; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY store (id_store, denomination, coordinates, address, phone, id_district, created_at, updated_at, status) FROM stdin;
2	A11	150,150	santiago	55	3	\N	\N	1
\.


--
-- TOC entry 2644 (class 0 OID 0)
-- Dependencies: 234
-- Name: store_id_store_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('store_id_store_seq', 2, true);


--
-- TOC entry 2534 (class 0 OID 24684)
-- Dependencies: 185
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY user_roles (user_role_id, user_id, role) FROM stdin;
1	1	ROLE_USER
2	2	ROLE_ADMIN
3	2	ROLE_USER
\.


--
-- TOC entry 2645 (class 0 OID 0)
-- Dependencies: 184
-- Name: user_roles_user_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('user_roles_user_role_id_seq', 3, true);


--
-- TOC entry 2532 (class 0 OID 24675)
-- Dependencies: 183
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (user_id, user_name, email, password, enabled) FROM stdin;
1	priya	abc@abc.com	$2a$04$CO93CT2ObgMiSnMAWwoBkeFObJlMYi/wzzOnPlsTP44r7qVq0Jln2	1
2	naveen	def@def.com	$2a$04$j3JpPUp6CTAe.kMWmdRNC.Wie58xDNPfcYz0DBJxWkucJ6ekJuiJm	1
\.


--
-- TOC entry 2646 (class 0 OID 0)
-- Dependencies: 182
-- Name: users_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_user_id_seq', 2, true);


--
-- TOC entry 2326 (class 2606 OID 24890)
-- Name: category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id_category);


--
-- TOC entry 2328 (class 2606 OID 24892)
-- Name: color_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY color
    ADD CONSTRAINT color_pkey PRIMARY KEY (id_color);


--
-- TOC entry 2330 (class 2606 OID 24894)
-- Name: country_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY country
    ADD CONSTRAINT country_pkey PRIMARY KEY (id_country);


--
-- TOC entry 2332 (class 2606 OID 24896)
-- Name: discount_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY discount
    ADD CONSTRAINT discount_pkey PRIMARY KEY (id_discount);


--
-- TOC entry 2334 (class 2606 OID 24898)
-- Name: discount_purchase_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY discount_purchase
    ADD CONSTRAINT discount_purchase_pkey PRIMARY KEY (id_discount_purchase);


--
-- TOC entry 2336 (class 2606 OID 24900)
-- Name: discount_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY discount_user
    ADD CONSTRAINT discount_user_pkey PRIMARY KEY (id_discount_user);


--
-- TOC entry 2338 (class 2606 OID 24902)
-- Name: district_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY district
    ADD CONSTRAINT district_pkey PRIMARY KEY (id_district);


--
-- TOC entry 2340 (class 2606 OID 24904)
-- Name: enviroment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY enviroment
    ADD CONSTRAINT enviroment_pkey PRIMARY KEY (id_enviroment);


--
-- TOC entry 2342 (class 2606 OID 24906)
-- Name: image_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY image
    ADD CONSTRAINT image_pkey PRIMARY KEY (id_image);


--
-- TOC entry 2344 (class 2606 OID 24908)
-- Name: ipn_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ipn
    ADD CONSTRAINT ipn_pkey PRIMARY KEY (id_ipn);


--
-- TOC entry 2346 (class 2606 OID 24910)
-- Name: offer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY offer
    ADD CONSTRAINT offer_pkey PRIMARY KEY (id_offer);


--
-- TOC entry 2350 (class 2606 OID 24912)
-- Name: order_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY order_detail
    ADD CONSTRAINT order_detail_pkey PRIMARY KEY (id_order_detail);


--
-- TOC entry 2348 (class 2606 OID 24914)
-- Name: order_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "order"
    ADD CONSTRAINT order_pkey PRIMARY KEY (id_order);


--
-- TOC entry 2352 (class 2606 OID 24916)
-- Name: palette_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY palette
    ADD CONSTRAINT palette_pkey PRIMARY KEY (id_palette);


--
-- TOC entry 2356 (class 2606 OID 24918)
-- Name: payment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY payment
    ADD CONSTRAINT payment_pkey PRIMARY KEY (id_payment);


--
-- TOC entry 2358 (class 2606 OID 24920)
-- Name: product_discount_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY product_discount
    ADD CONSTRAINT product_discount_pkey PRIMARY KEY (id_product_discount);


--
-- TOC entry 2360 (class 2606 OID 25156)
-- Name: product_offer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY product_offer
    ADD CONSTRAINT product_offer_pkey PRIMARY KEY (id_product_offer);


--
-- TOC entry 2362 (class 2606 OID 25031)
-- Name: products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id_product);


--
-- TOC entry 2364 (class 2606 OID 24926)
-- Name: purchase_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY purchase
    ADD CONSTRAINT purchase_pkey PRIMARY KEY (id_purchase);


--
-- TOC entry 2366 (class 2606 OID 24928)
-- Name: purpose_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY purpose
    ADD CONSTRAINT purpose_pkey PRIMARY KEY (id_purpose);


--
-- TOC entry 2368 (class 2606 OID 24930)
-- Name: rank_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rank
    ADD CONSTRAINT rank_pkey PRIMARY KEY (id_rank);


--
-- TOC entry 2370 (class 2606 OID 25211)
-- Name: relationated_product_id_product_id_product_relation_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relationated_product
    ADD CONSTRAINT relationated_product_id_product_id_product_relation_key UNIQUE (id_product, id_product_relation);


--
-- TOC entry 2372 (class 2606 OID 25066)
-- Name: relationated_product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relationated_product
    ADD CONSTRAINT relationated_product_pkey PRIMARY KEY (id_relationated_product);


--
-- TOC entry 2374 (class 2606 OID 24934)
-- Name: ship_info_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ship_info
    ADD CONSTRAINT ship_info_pkey PRIMARY KEY (id_ship_info);


--
-- TOC entry 2376 (class 2606 OID 24936)
-- Name: status_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY status
    ADD CONSTRAINT status_pkey PRIMARY KEY (id_status);


--
-- TOC entry 2378 (class 2606 OID 24938)
-- Name: store_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY store
    ADD CONSTRAINT store_pkey PRIMARY KEY (id_store);


--
-- TOC entry 2322 (class 2606 OID 24691)
-- Name: uni_userid_role; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_roles
    ADD CONSTRAINT uni_userid_role UNIQUE (role, user_id);


--
-- TOC entry 2324 (class 2606 OID 24689)
-- Name: user_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_roles
    ADD CONSTRAINT user_roles_pkey PRIMARY KEY (user_role_id);


--
-- TOC entry 2320 (class 2606 OID 24681)
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2353 (class 1259 OID 24939)
-- Name: password_resets_email_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX password_resets_email_index ON password_resets USING btree (email);


--
-- TOC entry 2354 (class 1259 OID 24940)
-- Name: password_resets_token_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX password_resets_token_index ON password_resets USING btree (token);


--
-- TOC entry 2385 (class 2606 OID 24941)
-- Name: discount_user_idDiscount_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY discount_user
    ADD CONSTRAINT "discount_user_idDiscount_fkey" FOREIGN KEY (id_discount) REFERENCES discount(id_discount);


--
-- TOC entry 2381 (class 2606 OID 24946)
-- Name: dpd_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY discount_purchase
    ADD CONSTRAINT dpd_fkey FOREIGN KEY (id_discount) REFERENCES discount(id_discount);


--
-- TOC entry 2382 (class 2606 OID 24951)
-- Name: dpp_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY discount_purchase
    ADD CONSTRAINT dpp_fkey FOREIGN KEY (id_purchase) REFERENCES purchase(id_purchase);


--
-- TOC entry 2401 (class 2606 OID 25110)
-- Name: fk11goj5bllpqi3bg8y6yxk0j0j; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products
    ADD CONSTRAINT fk11goj5bllpqi3bg8y6yxk0j0j FOREIGN KEY (id_color) REFERENCES color(id_color);


--
-- TOC entry 2414 (class 2606 OID 25145)
-- Name: fk26qkc1u6cw536yoysdxibl9ym; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY store
    ADD CONSTRAINT fk26qkc1u6cw536yoysdxibl9ym FOREIGN KEY (id_district) REFERENCES district(id_district);


--
-- TOC entry 2407 (class 2606 OID 25130)
-- Name: fk28wdl0gcw0vt4uv4j4t35v1yx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY purchase
    ADD CONSTRAINT fk28wdl0gcw0vt4uv4j4t35v1yx FOREIGN KEY (id_order) REFERENCES "order"(id_order);


--
-- TOC entry 2408 (class 2606 OID 25135)
-- Name: fk2kd0e31tqtej4qvc5s4pew52o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY purchase
    ADD CONSTRAINT fk2kd0e31tqtej4qvc5s4pew52o FOREIGN KEY (id_ship_info) REFERENCES ship_info(id_ship_info);


--
-- TOC entry 2384 (class 2606 OID 25075)
-- Name: fk47s1x55flg4ca2q6qu96sp14u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY discount_purchase
    ADD CONSTRAINT fk47s1x55flg4ca2q6qu96sp14u FOREIGN KEY (id_purchase) REFERENCES purchase(id_purchase);


--
-- TOC entry 2379 (class 2606 OID 24692)
-- Name: fk_userid; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_roles
    ADD CONSTRAINT fk_userid FOREIGN KEY (user_id) REFERENCES users(user_id);


--
-- TOC entry 2400 (class 2606 OID 25105)
-- Name: fkasih73m6q7t6gs9udyp5blisr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products
    ADD CONSTRAINT fkasih73m6q7t6gs9udyp5blisr FOREIGN KEY (id_category) REFERENCES category(id_category);


--
-- TOC entry 2386 (class 2606 OID 25080)
-- Name: fkddada6y3k75nwatubshc2o0s1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY discount_user
    ADD CONSTRAINT fkddada6y3k75nwatubshc2o0s1 FOREIGN KEY (id_discount) REFERENCES discount(id_discount);


--
-- TOC entry 2404 (class 2606 OID 25125)
-- Name: fkdyxm5ht81njxu7hv82w16xul8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products
    ADD CONSTRAINT fkdyxm5ht81njxu7hv82w16xul8 FOREIGN KEY (id_purpose) REFERENCES purpose(id_purpose);


--
-- TOC entry 2392 (class 2606 OID 25095)
-- Name: fke7jb3j9qxkmw9p02g8uxdwbff; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY order_detail
    ADD CONSTRAINT fke7jb3j9qxkmw9p02g8uxdwbff FOREIGN KEY (id_product) REFERENCES products(id_product);


--
-- TOC entry 2402 (class 2606 OID 25115)
-- Name: fkec9i3kcgdkjx1w6oto726k70; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products
    ADD CONSTRAINT fkec9i3kcgdkjx1w6oto726k70 FOREIGN KEY (id_enviroment) REFERENCES enviroment(id_enviroment);


--
-- TOC entry 2380 (class 2606 OID 25150)
-- Name: fkhfh9dx7w3ubf1co1vdev94g3f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_roles
    ADD CONSTRAINT fkhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id) REFERENCES users(user_id);


--
-- TOC entry 2394 (class 2606 OID 25200)
-- Name: fkjumhti33fr75x1p7u01wniqyd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY payment
    ADD CONSTRAINT fkjumhti33fr75x1p7u01wniqyd FOREIGN KEY (id_order) REFERENCES "order"(id_order);


--
-- TOC entry 2383 (class 2606 OID 25070)
-- Name: fkkefp1wxxl0x916xeajnlalgny; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY discount_purchase
    ADD CONSTRAINT fkkefp1wxxl0x916xeajnlalgny FOREIGN KEY (id_discount) REFERENCES discount(id_discount);


--
-- TOC entry 2412 (class 2606 OID 25140)
-- Name: fkkr7hn86gckytsfn8pko3cko2a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ship_info
    ADD CONSTRAINT fkkr7hn86gckytsfn8pko3cko2a FOREIGN KEY (id_district) REFERENCES district(id_district);


--
-- TOC entry 2388 (class 2606 OID 25085)
-- Name: fkm1fhrqra0gqmktwab354u1vvk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "order"
    ADD CONSTRAINT fkm1fhrqra0gqmktwab354u1vvk FOREIGN KEY (status) REFERENCES status(id_status);


--
-- TOC entry 2410 (class 2606 OID 25222)
-- Name: fkmmgatgvjwgs5xo6rntg0wdt42; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relationated_product
    ADD CONSTRAINT fkmmgatgvjwgs5xo6rntg0wdt42 FOREIGN KEY (id_product) REFERENCES products(id_product);


--
-- TOC entry 2391 (class 2606 OID 25090)
-- Name: fkrkrtk8187ncvngric1nvibn2i; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY order_detail
    ADD CONSTRAINT fkrkrtk8187ncvngric1nvibn2i FOREIGN KEY (id_order) REFERENCES "order"(id_order);


--
-- TOC entry 2403 (class 2606 OID 25120)
-- Name: fktpd7glgj0g2rhgeon0sa8gt33; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products
    ADD CONSTRAINT fktpd7glgj0g2rhgeon0sa8gt33 FOREIGN KEY (id_image) REFERENCES image(id_image);


--
-- TOC entry 2389 (class 2606 OID 24956)
-- Name: order_detail_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY order_detail
    ADD CONSTRAINT order_detail_fkey FOREIGN KEY (id_order) REFERENCES "order"(id_order);


--
-- TOC entry 2390 (class 2606 OID 25035)
-- Name: order_detail_id_product_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY order_detail
    ADD CONSTRAINT order_detail_id_product_fkey FOREIGN KEY (id_product) REFERENCES products(id_product);


--
-- TOC entry 2387 (class 2606 OID 24971)
-- Name: order_status_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "order"
    ADD CONSTRAINT order_status_fkey FOREIGN KEY (status) REFERENCES status(id_status);


--
-- TOC entry 2395 (class 2606 OID 24976)
-- Name: products_id_category_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products
    ADD CONSTRAINT products_id_category_fkey FOREIGN KEY (id_category) REFERENCES category(id_category);


--
-- TOC entry 2396 (class 2606 OID 24981)
-- Name: products_id_color_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products
    ADD CONSTRAINT products_id_color_fkey FOREIGN KEY (id_color) REFERENCES color(id_color);


--
-- TOC entry 2397 (class 2606 OID 24986)
-- Name: products_id_enviroment_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products
    ADD CONSTRAINT products_id_enviroment_fkey FOREIGN KEY (id_enviroment) REFERENCES enviroment(id_enviroment);


--
-- TOC entry 2398 (class 2606 OID 24991)
-- Name: products_id_image_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products
    ADD CONSTRAINT products_id_image_fkey FOREIGN KEY (id_image) REFERENCES image(id_image);


--
-- TOC entry 2399 (class 2606 OID 24996)
-- Name: products_id_purpose_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products
    ADD CONSTRAINT products_id_purpose_fkey FOREIGN KEY (id_purpose) REFERENCES purpose(id_purpose);


--
-- TOC entry 2405 (class 2606 OID 25001)
-- Name: purchase_order_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY purchase
    ADD CONSTRAINT purchase_order_fkey FOREIGN KEY (id_order) REFERENCES "order"(id_order);


--
-- TOC entry 2393 (class 2606 OID 25006)
-- Name: purchase_order_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY payment
    ADD CONSTRAINT purchase_order_fkey FOREIGN KEY (id_order) REFERENCES "order"(id_order);


--
-- TOC entry 2406 (class 2606 OID 25011)
-- Name: purchase_ship_info_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY purchase
    ADD CONSTRAINT purchase_ship_info_fkey FOREIGN KEY (id_ship_info) REFERENCES ship_info(id_ship_info);


--
-- TOC entry 2409 (class 2606 OID 25195)
-- Name: relationated_product_id_product_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relationated_product
    ADD CONSTRAINT relationated_product_id_product_fkey FOREIGN KEY (id_product) REFERENCES products(id_product);


--
-- TOC entry 2411 (class 2606 OID 25016)
-- Name: ship_info_id_district_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ship_info
    ADD CONSTRAINT ship_info_id_district_fkey FOREIGN KEY (id_district) REFERENCES district(id_district);


--
-- TOC entry 2413 (class 2606 OID 25021)
-- Name: store_district_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY store
    ADD CONSTRAINT store_district_fkey FOREIGN KEY (id_district) REFERENCES district(id_district);


--
-- TOC entry 2593 (class 0 OID 0)
-- Dependencies: 7
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-04-25 00:26:22 CLST

--
-- PostgreSQL database dump complete
--

