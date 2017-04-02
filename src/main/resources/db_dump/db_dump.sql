--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.1
-- Dumped by pg_dump version 9.6.1

-- Started on 2017-04-02 17:10:47

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2160 (class 1262 OID 12401)
-- Dependencies: 2159
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 6 (class 2615 OID 16393)
-- Name: PictureGallery; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA "PictureGallery";


ALTER SCHEMA "PictureGallery" OWNER TO postgres;

--
-- TOC entry 2 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2162 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 1 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 2163 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET search_path = "PictureGallery", pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 189 (class 1259 OID 16413)
-- Name: authority; Type: TABLE; Schema: PictureGallery; Owner: postgres
--

CREATE TABLE authority (
    name text,
    id integer NOT NULL
);


ALTER TABLE authority OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 16451)
-- Name: authority_id_seq; Type: SEQUENCE; Schema: PictureGallery; Owner: postgres
--

CREATE SEQUENCE authority_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE authority_id_seq OWNER TO postgres;

--
-- TOC entry 2164 (class 0 OID 0)
-- Dependencies: 193
-- Name: authority_id_seq; Type: SEQUENCE OWNED BY; Schema: PictureGallery; Owner: postgres
--

ALTER SEQUENCE authority_id_seq OWNED BY authority.id;


--
-- TOC entry 191 (class 1259 OID 16424)
-- Name: picture; Type: TABLE; Schema: PictureGallery; Owner: postgres
--

CREATE TABLE picture (
    id integer NOT NULL,
    author text,
    name text,
    description text,
    owner text,
    tags text,
    pathtoimage text
);


ALTER TABLE picture OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 16422)
-- Name: picture_id_seq; Type: SEQUENCE; Schema: PictureGallery; Owner: postgres
--

CREATE SEQUENCE picture_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE picture_id_seq OWNER TO postgres;

--
-- TOC entry 2165 (class 0 OID 0)
-- Dependencies: 190
-- Name: picture_id_seq; Type: SEQUENCE OWNED BY; Schema: PictureGallery; Owner: postgres
--

ALTER SEQUENCE picture_id_seq OWNED BY picture.id;


--
-- TOC entry 188 (class 1259 OID 16402)
-- Name: user_authority; Type: TABLE; Schema: PictureGallery; Owner: postgres
--

CREATE TABLE user_authority (
    user_id integer NOT NULL,
    authority_id integer NOT NULL
);


ALTER TABLE user_authority OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 16394)
-- Name: users; Type: TABLE; Schema: PictureGallery; Owner: postgres
--

CREATE TABLE users (
    name text,
    password text,
    id integer NOT NULL
);


ALTER TABLE users OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 16442)
-- Name: user_id_seq; Type: SEQUENCE; Schema: PictureGallery; Owner: postgres
--

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE user_id_seq OWNER TO postgres;

--
-- TOC entry 2166 (class 0 OID 0)
-- Dependencies: 192
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: PictureGallery; Owner: postgres
--

ALTER SEQUENCE user_id_seq OWNED BY users.id;


--
-- TOC entry 2023 (class 2604 OID 16464)
-- Name: authority id; Type: DEFAULT; Schema: PictureGallery; Owner: postgres
--

ALTER TABLE ONLY authority ALTER COLUMN id SET DEFAULT nextval('authority_id_seq'::regclass);


--
-- TOC entry 2024 (class 2604 OID 16427)
-- Name: picture id; Type: DEFAULT; Schema: PictureGallery; Owner: postgres
--

ALTER TABLE ONLY picture ALTER COLUMN id SET DEFAULT nextval('picture_id_seq'::regclass);


--
-- TOC entry 2022 (class 2604 OID 16461)
-- Name: users id; Type: DEFAULT; Schema: PictureGallery; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);


--
-- TOC entry 2150 (class 0 OID 16413)
-- Dependencies: 189
-- Data for Name: authority; Type: TABLE DATA; Schema: PictureGallery; Owner: postgres
--

COPY authority (name, id) FROM stdin;
ROLE_USER	1
ROLE_ADMIN	2
\.


--
-- TOC entry 2167 (class 0 OID 0)
-- Dependencies: 193
-- Name: authority_id_seq; Type: SEQUENCE SET; Schema: PictureGallery; Owner: postgres
--

SELECT pg_catalog.setval('authority_id_seq', 2, true);


--
-- TOC entry 2152 (class 0 OID 16424)
-- Dependencies: 191
-- Data for Name: picture; Type: TABLE DATA; Schema: PictureGallery; Owner: postgres
--

COPY picture (id, author, name, description, owner, tags, pathtoimage) FROM stdin;
1	Victor Vasnetsov	Bogatyri	Vasnetsov worked on a picture about twenty years. On April 23, 1898 it has been finished and soon bought by P. M. Tretyakov for the gallery.	Oleg	Bogatyri,Vasnetsov,classics	C:\\Users\\Oleg\\workspace\\HelloWorldTomcat\\pictures\\Victor_VasnetsovVictor_Vasnetsov_-_Victor_VasnetsovVictor_Vasnetsov_-_Heroes_(Bogatyri).jpg
\.


--
-- TOC entry 2168 (class 0 OID 0)
-- Dependencies: 190
-- Name: picture_id_seq; Type: SEQUENCE SET; Schema: PictureGallery; Owner: postgres
--

SELECT pg_catalog.setval('picture_id_seq', 1, false);


--
-- TOC entry 2149 (class 0 OID 16402)
-- Dependencies: 188
-- Data for Name: user_authority; Type: TABLE DATA; Schema: PictureGallery; Owner: postgres
--

COPY user_authority (user_id, authority_id) FROM stdin;
1	2
2	1
5	1
\.


--
-- TOC entry 2169 (class 0 OID 0)
-- Dependencies: 192
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: PictureGallery; Owner: postgres
--

SELECT pg_catalog.setval('user_id_seq', 5, true);


--
-- TOC entry 2148 (class 0 OID 16394)
-- Dependencies: 187
-- Data for Name: users; Type: TABLE DATA; Schema: PictureGallery; Owner: postgres
--

COPY users (name, password, id) FROM stdin;
Oleg	123	1
Pavel	123	2
test	123	5
\.


--
-- TOC entry 2028 (class 2606 OID 16466)
-- Name: authority authority_pkey; Type: CONSTRAINT; Schema: PictureGallery; Owner: postgres
--

ALTER TABLE ONLY authority
    ADD CONSTRAINT authority_pkey PRIMARY KEY (id);


--
-- TOC entry 2030 (class 2606 OID 16432)
-- Name: picture picture_pkey; Type: CONSTRAINT; Schema: PictureGallery; Owner: postgres
--

ALTER TABLE ONLY picture
    ADD CONSTRAINT picture_pkey PRIMARY KEY (id);


--
-- TOC entry 2026 (class 2606 OID 16463)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: PictureGallery; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


-- Completed on 2017-04-02 17:10:47

--
-- PostgreSQL database dump complete
--

