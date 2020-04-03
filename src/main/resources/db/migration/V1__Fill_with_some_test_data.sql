--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12.1

-- Started on 2020-04-02 00:46:32

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 204 (class 1259 OID 23742)
-- Name: auction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.auction (
                                id bigint NOT NULL,
                                created_date timestamp without time zone,
                                last_modified_date timestamp without time zone,
                                version integer,
                                active boolean NOT NULL,
                                description character varying(255),
                                end_date timestamp without time zone,
                                owner_account_id bigint NOT NULL,
                                owner_id bigint NOT NULL,
                                price numeric(19,2),
                                quantity integer NOT NULL,
                                start_date timestamp without time zone,
                                title character varying(255)
);


ALTER TABLE public.auction OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 23738)
-- Name: auction_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.auction_sequence
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.auction_sequence OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 23740)
-- Name: order_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.order_sequence
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.order_sequence OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 23750)
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
                               id bigint NOT NULL,
                               created_date timestamp without time zone,
                               last_modified_date timestamp without time zone,
                               version integer,
                               auction_id bigint NOT NULL,
                               client_account_number character varying(255),
                               client_id bigint NOT NULL,
                               owner_account_id bigint NOT NULL,
                               owner_id bigint NOT NULL,
                               quantity integer NOT NULL,
                               status character varying(255),
                               unit_price numeric(19,2)
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- TOC entry 2827 (class 0 OID 23742)
-- Dependencies: 204
-- Data for Name: auction; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.auction (id, created_date, last_modified_date, version, active, description, end_date, owner_account_id, owner_id, price, quantity, start_date, title) FROM stdin;
1	2020-04-02 00:35:55.816	2020-04-02 00:35:55.816	0	t	Chińskie dzieło sztuki	2020-05-02 00:35:55.767619	2	2	33.00	5	2020-04-02 00:35:55.767619	Bezcenna waza z dynastii Ming
2	2020-04-02 00:39:21.237	2020-04-02 00:39:21.237	0	t	Bezcenna broń na Koronawirusa	2020-05-02 00:39:21.235949	7	4	99.00	15	2020-04-02 00:39:21.235949	Maseczki ochronne wielorazowe
3	2020-04-02 00:41:36.087	2020-04-02 00:41:36.087	0	t	Kultowe klapki z lat 90	2020-04-17 00:41:36.086448	3	3	19.00	50	2020-04-02 00:41:36.086448	Klapki Kubota
4	2020-04-02 00:44:48.529	2020-04-02 00:44:48.529	0	t	Ulubiona zabawka na 15 minut	2020-04-17 00:44:48.528864	6	2	9.00	100	2020-04-02 00:44:48.528864	Fidżet spinner
\.


--
-- TOC entry 2828 (class 0 OID 23750)
-- Dependencies: 205
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orders (id, created_date, last_modified_date, version, auction_id, client_account_number, client_id, owner_account_id, owner_id, quantity, status, unit_price) FROM stdin;
\.


--
-- TOC entry 2834 (class 0 OID 0)
-- Dependencies: 202
-- Name: auction_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.auction_sequence', 51, true);


--
-- TOC entry 2835 (class 0 OID 0)
-- Dependencies: 203
-- Name: order_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.order_sequence', 1, false);


--
-- TOC entry 2696 (class 2606 OID 23749)
-- Name: auction auction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auction
    ADD CONSTRAINT auction_pkey PRIMARY KEY (id);


--
-- TOC entry 2698 (class 2606 OID 23757)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


-- Completed on 2020-04-02 00:46:32

--
-- PostgreSQL database dump complete
--

